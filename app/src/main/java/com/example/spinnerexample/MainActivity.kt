package com.example.spinnerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.spinnerexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val balls = listOf("Basketball", "Football", "Baseball")    //data source

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure the spinner
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, balls)

        //spinner dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selected = parent?.getItemAtPosition(position).toString()
                binding.resultText.text = getString(R.string.your_selection, selected)
                //binding.resultText.text = "Your selection is " + selected
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}
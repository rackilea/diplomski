setContentView(R.layout.main);
spinnerdropdown = (AutoCompleteTextView) findViewById(R.id.spinnerDropDown);
ArrayAdapter<String> stringArrayAdapter=
    new ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line,
            locations 
    ); 
spinnerdropdown.setThreshold(1); 
spinnerdropdown.setAdapter(stringArrayAdapter);
spinnerdropdown.setTextColor(Color.RED);
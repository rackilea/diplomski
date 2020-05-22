spin = (Spinner) findViewById(R.id.spinner);
ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(
             this, 
             android.R.layout.simple_spinner_dropdown_item,
             getResources().getStringArray(R.array.punpColleges));
spin.setAdapter(spinnerAdapter);
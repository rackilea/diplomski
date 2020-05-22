//Create Array Adapter
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, languages);
//Find TextView control AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.languages);
//Set the number of characters the user must type before the drop down list is shown
acTextView.setThreshold(1);
//Set the adapter acTextView.setAdapter(adapter);
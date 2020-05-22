final ArrayList<String> providerlist= new ArrayList<String>();
Spinner spinner1 = (Spinner) findViewById(R.id.prospin);
ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, providerlist);

adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
spinner1.setAdapter(adapter1); 
spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { 
    @Override 
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        // On selecting a spinner item 
        String item = providerlist.get(position);

        // Showing selected spinner item 
        Toast.makeText(this,
                "Selected Country : " + item, Toast.LENGTH_LONG).show();
    } 

    @Override 
    public void onNothingSelected(AdapterView<?> parent) {

    } 
});
String items[] = new String[2];
items[0] = String.valueOf("Item #1");
items[0] = String.valueOf("Item #2");

ArrayAdapter<String> spinnerArrayAdapter =
    new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);

spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

Spinner spinner = (Spinner) findViewById(R.id.spinner);
spinner.setAdapter(spinnerArrayAdapter);
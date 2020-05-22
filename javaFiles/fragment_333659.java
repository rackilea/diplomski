myString.replace("\"]","");
myString.replace("[\"","");

List<String> myList = new ArrayList<String>(Arrays.asList(s.split("\",\"")));


ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(varRoot, android.R.layout.simple_spinner_item, myList);

spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down vieww

mySpinner.setAdapter(spinnerArrayAdapter);
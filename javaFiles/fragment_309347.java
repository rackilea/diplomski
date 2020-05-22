public void showDataInSpinner(ArrayList<String> data) {
          ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_spinner_item, data
            ); //Create the Adapter to set the data
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //Set the layout resource to create the drop down views.
            youSpinner.setAdapter(adapter); //Set the data to your spinner
    }
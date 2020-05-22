OnItemSelectedListener itemSelectedHandler = new OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int pos, long row) {
        String str = parent.getItemAtPosition(pos).toString();
        // Do whatever you want with the string
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // Do nothing
    }
};
//set the spinner's listener for select event

mSpinner.setOnItemSelectedListener(itemSelectedHandler);
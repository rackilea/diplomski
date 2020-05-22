categoriesSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedPosition = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
});
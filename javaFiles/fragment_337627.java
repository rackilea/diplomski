// Second adapter is a class field
private ArrayAdapter<String> secondSpinnerAdapter;

// Initialize it ONCE in onCreate with no items to begin with
secondSpinnerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line);
materialDesignSpinner2.setAdapter(secondSpinnerAdapter);

// When something is selected in the first adapter,
// update the options in the second adapter
materialDesignSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        secondSpinnerAdapter.clear();
        secondSpinnerAdapter.addAll(getStringsForPosition(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});

private String[] getStringsForPosition(int position) {
    switch(position) {
        case 0: return getResources().getStringArray(R.array.musandam_hospitals);
        // Add other cases
    }
}
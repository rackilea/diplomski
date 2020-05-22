mIo = (Spinner) view.findViewById(R.id.schedulerSpinner);
String[] availableIo = {"one", "two", "three", "four"};
ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(getActivity(),android.R.layout.simple_spinner_item, availableIo);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
mIo.setAdapter(adapter);
//SET SELECTION AFTER YOU SET THE ADAPTER NOT BEFORE IT
mIo.setSelection(preferences.getInt("spinnerSelection",0));
mIo.setOnItemSelectedListener(new OnItemSelectedListener() {

    public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
        int item = mIo.getSelectedItemPosition();

        String selected = mIo.getItemAtPosition(position).toString();
        Toast.makeText(this, "Selected item: " + selected, Toast.LENGHT_SHORT).show();
        editor = preferences.edit();
        editor.putInt("spinnerSelection", item);
        editor.commit();

    }
    public void onNothingSelected(AdapterView<?> arg0) {

     }
});
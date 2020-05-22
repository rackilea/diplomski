public void fillSpinner(String spinner_name, final String field_name,
                    final OnSpinnerValueSelected valueChangeListener) {

    // Prepare spinner

    s.setOnItemSelectedListener(new OnItemSelectedListener() {

        public void onItemSelected(AdapterView<?> parent, View view,
                     int position, long id) {
            Cursor theCursor = (Cursor) parent.getSelectedItem();

            valueChangeListener.onValueSelected(theCursor
                           .getString(theCursor.getColumnIndex(field_name)));
        }

        public void onNothingSelected(AdapterView<?> parent) {

        }
    });
}
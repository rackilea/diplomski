spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1,
            int position, long arg3) {

        String selectedItem=spinner.getSelectedItem().toString();
        mTextView_1.setText(selectedItem);
        mTextView_2.setText(selectedItem);
        mTextView_3.setText(selectedItem);
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {                
    }
});
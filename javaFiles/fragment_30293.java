final String[] array=getResources().getStringArray(R.array.material_array);
spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1,
            int position, long arg3) {

        mTextView_1.setText(array[position]);
        mTextView_2.setText(array[position]);
        mTextView_3.setText(array[position]);
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {                
    }
});
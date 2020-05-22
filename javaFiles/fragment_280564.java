public void buttonOnClick(View v){
    // do something when the button is clicked

    Double inputNum;

    TextView mField = (TextView) findViewById(R.id.mField);
    TextView kmField = (TextView) findViewById(R.id.kmField);

    if(kmField.getText().toString().isEmpty()){
        inputNum = ( Double.valueOf(kmField.getText().toString()) )/ 0.62137;
        mField.setText(inputNum.toString());
    }
}
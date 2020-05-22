public void onClick(View v){
    //Retrieve all the information, and set the values in the Calculator
    String number = mEditText.getText().toString();
    double angle = Double.parseDouble(number);

    Calculator.longCalc();
}
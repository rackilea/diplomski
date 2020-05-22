public void eightNumber(View view) {
    TextView t = (TextView) findViewById(R.id.textView);
    temp = t.getText();
    temp = temp + "8"

    //convert the input number to double to avoid extra zero before digits (05)
    double tempNumber = Double.parseDouble(temp);
    //convert our double number back to string, to use it in textView.setText method
    temp = String.valueOf(tempNumber);

    //to avoid redundant ".0" after integer numbers:
    //if 2 last digits of the number is .0, we delete it
    if(temp.lastIndexOf(".0") == temp.length() - 2){
        temp = temp.substring(0, temp.length() - 2);
    }

    t.setText(temp);
}
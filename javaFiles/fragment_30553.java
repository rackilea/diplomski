if(minu){
    number1 = Double.valueOf(display1.getText().toString());
    number2 = Double.valueOf(display2.getText().toString());

    display1.setText("");
    display2.setText("");
    displaySymbol.setText("");

    answer = number1 - number2;

    display1.setText(Double.toString(answer));
}
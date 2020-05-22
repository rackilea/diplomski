public void getOperator(String btnText){
    theOperator = btnText.charAt(0);


    displayValue = Double.parseDouble(display.getText().ToString());
    total1+=displayValue;
    display.setText("");
}
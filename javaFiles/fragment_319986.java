try{
    DecimalFormat df = new DecimalFormat("#.###"); // provide the format you actually want.
    float numOne = Float.parseFloat(numberOne.getText());
    float numTwo = Float.parseFloat(numberTwo.getText());
    float anser = numOne+numTwo;
    String AR = df.format(anser);
    answerLabel.setText(AR);
}
catch(NumberFormatException nfe){
    answerLabel.setText(null);
}
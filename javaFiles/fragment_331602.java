int currentValue = 0; //at the beginning, the user has not typed anything

//here, I am assuming you have a method that listens for all the button presses, then you could
//call a method like this depending on which button was pressed
public void buttonPressed(String value) {
    currentValue += Integer.parseInt(value);
    calculatorLabelDisplay.setText(Integer.toString(currentValue));
}

//here, I am assuming there is some button listener for the "clear" button
public void clearButtonPressed() {
    currentValue = 0;
}
try {
    b = Integer.parseInt(theApp.tgreen.getText());
    ...
} catch (NumberFormatException ey) {
    message.setText("invalid input! please enter numbers only");
    ...
}
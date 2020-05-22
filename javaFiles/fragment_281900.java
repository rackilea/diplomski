public void mouseClicked(MouseEvent arg0) {
    // Create an instance of your NumberGen class
    NumberGen numberGenerator = new NumberGen();
    // Set the text field to the random number
    textField_tf1.setText(numberGenerator.getRandom());
}
public void actionPerformed(ActionEvent evt) {
   String text = myTextField.getText();
   int myInt = Integer.parseInt(text); // better to surround with try/catch
   myArray[counter] = myInt;
   counter++; // to move to the next counter
}
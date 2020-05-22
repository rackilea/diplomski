int numberInField;
try {
  numberInField = Integer.parseInt(myTextField.getText());
} catch (NumberFormatException ex) {
  //maybe display an error message;
  JOptionPane.showMessageDialog(null, "Bad Input", "Field 'whatever' requires an integer value", JOptionPane.ERROR_MESSAGE);
  return;
}
// you have a proper integer, insert code for what you want to do with it here
boolean validX = false;
String stringPointOneX = JOptionPane.showInputDialog(null, "What would you like the x value of the first coordinate to be?");

while (!validX) {
  try {
    pointOneX = Double.valueOf(stringPointOneX);
    validX = true; // Only comes here, if no error thrown.
  } catch (NumberFormatException e) {
    stringPointOneX = JOptionPane.showMessageDialog(null,"Error! Incorrect point value. Please input values again");
  }
}
for (int i = 0; i < textFields.length; i++) {
  String value = textFields[i].getText().trim();
  if (value.isEmpty()) { 
    bet[i] = 0;
  } else {
    try {
       bet[i] = Integer.parseInt(value);
    } catch (NumberFormatException nfe) {
       // JOptionPane to notify user that textfield i's text is non-numeric
       // set textfield's text to ""
    }
  }
}
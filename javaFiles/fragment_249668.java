public boolean dialogHandler(int op, JTextField text, JLabel nonDigit) {

  String s = text.getText();

  if (op == JOptionPane.OK_OPTION) {
    if (s.isEmpty()) {
      return false; // If the text is empty we return false for the flag.
    } else {
      try {
        target = Integer.parseInt(s);
        return true; // If parse was succesful, we return true for the flag.
      } catch (Exception e) { 
        return false; // If the exception happened, return false for the flag.
      }
    }
  } else if (op == JOptionPane.CLOSED_OPTION) {
    System.exit(0);
  }
}
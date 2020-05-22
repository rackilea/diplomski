JTextField field = new JTextField ();

field.setDocument (new PlainDocument () {
  public void insertString (int off, String str, AttributeSet attr) throws BadLocationException {
    if (off < 10) {  // max size clause
      if (off == 1 || off == 6) { // insert the '/' occasionally
        str = str + "/";
      }
      super.insertString (off, str, attr);
    }
  }
});

field.setText ("xx/xxxx/xx"); // set AFTER otherwise default won't show up!
field.setForeground (ColorConstants.DARK_GRAY_080); // make it light! 
field.addFocusListener (new ClearingFocusListener (field)); // could be done in an anonymous inner class - but I use it other places

private static class ClearingFocusListener implements FocusListener {
  final private String initialText;
  final private JTextField field;

  public ClearingFocusListener (final JTextField field) {
    this.initialText = field.getText ();
    this.field = field;
  }

  @Override
  public void focusGained (FocusEvent e) {
    if (initialText.equals (field.getText ())) {
      field.setText ("");
      field.setForeground (ColorConstants.DARK_GRAY_080);
    }
  }

  @Override
  public void focusLost (FocusEvent e) {
    if ("".equals (field.getText ())) {
      field.setText (initialText);
      field.setForeground (ColorConstants.LIGHT_GRAY_220);
    }
  }
}
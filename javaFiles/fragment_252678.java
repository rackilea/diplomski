myTextField.addFocusListener(new FocusListener() {
  public void focusGained(FocusEvent e){
    // get text from JTextField
    // if text matches default text, either select all, so user can keep it or change it
    // or delete it --- your choice
  }

  public void foucsLost(FocusEvent e){
    // check if JTextField's text is empty.
    // if so, cal setText(DEFAULT_TEXT) on the field
  }
});
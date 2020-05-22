textField.getDocument().addDocumentListener(new DocumentListener() {
  public void changedUpdate(DocumentEvent e) {
    doSomethingInAnotherTextfield();
  }
  public void removeUpdate(DocumentEvent e) {
    doSomethingInAnotherTextfield();
  }
  public void insertUpdate(DocumentEvent e) {
    doSomethingInAnotherTextfield();
  }

  public void doSomethingInAnotherTextfield() {
     //whatever you have to do
  }
});
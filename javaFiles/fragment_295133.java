void init() {
  //construct text fields
  ...
  // add listeners
  textField1.getDocument().addDocumentListener(new DocumentListener() {
    public void changedUpdate(DocumentEvent e) {
      checkUnlock();
    }
    public void removeUpdate(DocumentEvent e) {
      checkUnlock();
    } 
    public void insertUpdate(DocumentEvent e) {
      checkUnlock();
    });

   // repeat for each textfield
}
...
private void checkUnlock() {
  boolean unlock = !(textField1.getText().equals("")) && !(textField2.getText().equals("")); // ... and so on
  yourButton.setEnabled(unlock);
}
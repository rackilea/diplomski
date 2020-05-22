// Listen for changes in the text
textField.getDocument().addDocumentListener(new DocumentListener() {
  public void changedUpdate(DocumentEvent e) {
    warn();
  }
  public void removeUpdate(DocumentEvent e) {
    warn();
  }
  public void insertUpdate(DocumentEvent e) {
    warn();
  }

  public void warn() {
     if (Integer.parseInt(textField.getText())<=0){
       JOptionPane.showMessageDialog(null,
          "Error: Please enter number bigger than 0", "Error Message",
          JOptionPane.ERROR_MESSAGE);
     }
  }
});
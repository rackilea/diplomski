// Listen for changes in the text
textField.getDocument().addDocumentListener(new DocumentListener() {
  public void changedCell(DocumentEvent e) {
    update();
  }
  public void removeCell(DocumentEvent e) {
    update();
  }
  public void addCell(DocumentEvent e) {
    update();
  }

  public void update() {
     if (Integer.parseInt(textField.getText())<=0){
       // Do update 
     }
  }
});
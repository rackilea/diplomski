numberField.getDocument().addDocumentListener(new DocumentListener() {
  @Override public void insertUpdate(DocumentEvent e) {
    //Container c = numberField.getParent();
    Container c = SwingUtilities.getUnwrappedParent(numberField);
    if (c != null) {
      c.repaint();
    }
  }
  @Override public void removeUpdate(DocumentEvent e) {
    insertUpdate(e);
  }
  @Override public void changedUpdate(DocumentEvent e) {}
});
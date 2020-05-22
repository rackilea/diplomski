private class TextChangeListener implements DocumentListener {
  @Override
  public void changedUpdate(DocumentEvent e) {
     update(e);
  }

  @Override
  public void insertUpdate(DocumentEvent e) {
     update(e);
  }

  @Override
  public void removeUpdate(DocumentEvent e) {
     update(e);
  }
}
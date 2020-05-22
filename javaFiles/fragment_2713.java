myTextField.addKeyListener(new KeyAdapter() {
  @Override
  public void keyTyped(KeyEvent e) {
    char c = e.getKeyChar();
    if (!Character.isDigit(c)) {
      e.consume(); // Stop the event from propagating.
    }
  }
});
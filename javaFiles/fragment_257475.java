textField.addKeyListener(new KeyListener(){

  public void keyTyped(KeyEvent e) {
    char c = e.getKeyChar();
     if (c== ',')
       e.setKeyChar('.');
  }
});
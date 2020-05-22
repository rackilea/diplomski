JTextArea jtf1 = new JTextArea();
jtf1.getInputMap().put(
  KeyStroke.getKeyStroke(KeyEvent.VK_ALT, InputEvent.ALT_DOWN_MASK), 
  "handleGS"
);
jtf1.getActionMap().put("handleGS", new AbstractAction() {
  public void actionPerformed(java.awt.event.ActionEvent e) {
    System.err.println("Found");
  }
});
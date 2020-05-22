button.addMouseListener(new MouseAdapter() {
  public void mousePressed(MouseEvent e) {
    button.setBorder(BorderFactory.createLoweredBevelBorder());
  }

  public void mouseReleased(MouseEvent e) {
    button.setBorder(null);
  }
});
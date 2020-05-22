// --------- This mouse pressed never gets called why?
label.addMouseListener(new MouseAdapter() {
  @Override
  public void mousePressed(MouseEvent e) {
    MousePressed(e)
  };

  public void MousePressed(MouseEvent e) {
    label.setVisible(false);
  }
});
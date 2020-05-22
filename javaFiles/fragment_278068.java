public void mousePressed(MouseEvent event) {
  event.getComponent().setEnabled(false);
  try {

    // ....

  } finally {
    event.getComponent().setEnabled(true);
}
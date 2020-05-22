@Override public int getSourceActions(JComponent src) {
  JLabel label = (JLabel)src;
  window.add(label);
  window.pack();
  window.setVisible(true);
  return MOVE;
}
//...
DragSource.getDefaultDragSource().addDragSourceMotionListener(new DragSourceMotionListener() {
  @Override public void dragMouseMoved(DragSourceDragEvent dsde) {
    Point pt = dsde.getLocation();
    pt.translate(5, 5); // offset
    window.setLocation(pt);
  }
});
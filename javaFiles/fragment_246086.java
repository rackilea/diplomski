//http://stackoverflow.com/questions/4893265/dragging-a-jlabel-around-the-screen
private final JWindow window = new JWindow();
@Override
public void mouseDragged(MouseEvent me) {
  if (dragLabel == null) {
      return;
  }
  int x = me.getPoint().x - dragLabelWidthDiv2;
  int y = me.getPoint().y - dragLabelHeightDiv2;
  //dragLabel.setLocation(x, y);
  window.add(dragLabel);
  window.pack();
  Point pt = new Point(x, y);
  Component c = (Component)me.getSource();
  SwingUtilities.convertPointToScreen(pt, c);
  window.setLocation(pt);
  window.setVisible(true);
  repaint();
}
@Override public void mouseReleased(MouseEvent me) {
  window.setVisible(false);
  //...
}
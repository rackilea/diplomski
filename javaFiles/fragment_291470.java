@Override
public void mouseDragged(MouseEvent e) {
  messageX = e.getX();
  messageY = e.getY();
  repaint();
}
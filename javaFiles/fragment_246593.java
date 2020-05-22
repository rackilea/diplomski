public void mouseClicked(MouseEvent e) {
PointerInfo a = MouseInfo.getPointerInfo();
Point point = new Point(a.getLocation());
SwingUtilities.convertPointFromScreen(point, e.getComponent());
x=(int) point.getX();
y=(int) point.getY();
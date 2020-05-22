// variable declarations
Point initialPoint = null;
Rectangle rectangle = null;

@Override
public void mousePressed(MouseEvent mEvt) {
  initialPoint = mEvt.getPoint();
  rectangle = null;
  repaint();
}

mouseDragged(MouseEvent mEvt) {
  // use initialPoint, mEvt.getPoint(), 
  // Math.abs(...), Math.min(...), and Math.max(...)
  // to calculate x, y, w, and h
  rectangle = new Rectangle(x, y, w, h);
  repaint();
}
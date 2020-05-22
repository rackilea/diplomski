// the method from MouseListener we're interested in this time
 @Override
 public void mousePressed( MouseEvent e) {
     this.x = e.getX();
     this.y = e.getY();
     this.repaint();
 }
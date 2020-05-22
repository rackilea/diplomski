boolean isLaser = false;

public void keyPressed(KeyEvent e) {
  isLaser = true;
}

public void keyReleased(KeyEvent e) {
  isLaser = false;
}

public void paintComponent(Graphics g) {
  if (isLaser)
    // do something
}
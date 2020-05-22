@Override
protected void paintComponent(Graphics g) {
  Graphics2D g2d = (Graphics2D) g;
  g2d.rotate(Math.PI);
  super.paintComponent(g2d);
}
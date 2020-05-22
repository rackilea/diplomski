@Override
public void paintComponent(Graphics g) {
  super.paintComponent(g);
  if (rectangle != null) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.BLUE);
    g2.fill(rectangle);
  }
}
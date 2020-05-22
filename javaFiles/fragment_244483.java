protected void paintComponent(Graphics g) {
   Graphics2D g2 = ( Graphics2D )g;
   g2.rotate(theta);
   super.paintComponent(g2);
   g2.rotate(-theta);
}
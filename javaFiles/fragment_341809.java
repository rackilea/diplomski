public void paint(Graphics g) {
    super.paint(g);
    int x = getWidth() /2 ;
    int y = getHeight() / 2;
    g.drawOval(x, y, 10, 10);
}
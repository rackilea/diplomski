public void draw(Graphics g, int x, int y) {
    this.x = x;
    this.y = y;

    g.setColor(Color.red);
    g.fillRect(x, y, 10, 10);
    g.setColor(Color.white);
    g.drawRect(x, y, 10, 10);
}
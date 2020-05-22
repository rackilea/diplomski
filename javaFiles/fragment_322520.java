public int getSide() {
    int width = this.getWidth();
    int height = this.getHeight();
    if (width <= height) {
        return width;
    } else {
        return height;
    }
}

public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int side = getSide();
    if (side == 0) return;
    drawSierpTriangle(g, this.x, this.y, side);
    g.drawRect(x, y, 1, 1);
}
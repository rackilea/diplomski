class BlackRect {
    int x, y;
    int w = 100, h = 100;

    public BlackRect(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x, y, w, h);
    }
}
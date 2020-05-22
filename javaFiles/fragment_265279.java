class MyLine {
    private final int startX, startY;
    private final int endX, endY;
    private final Color color;

    public MyLine(int startX, int startY, int endX, int endY, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(startX, startY, endX, endY);
    }
}
public class Ball implements Drawable {
    private int x, y;
    private JPanel surface;
    public Ball(int x, int y, JPanel surface) {
        this.x = x;
        this.y = y;
        this.surface = surface;
    }

    @Override
    public void draw(Graphics g) {
        g.fillOval(x, y, sirface.getWidth(), surface.getHeight());
    }
}
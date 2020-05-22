public class DefaultBox implements Box {

    private Color color;
    private Rectangle bounds;

    private int xDelta;
    private int yDelta;

    public DefaultBox(Color color, Dimension size) {
        this.color = color;
        bounds = new Rectangle(new Point(0, 0), size);

        xDelta = 1 + (int) (Math.random() * 10);
        yDelta = 1 + (int) (Math.random() * 10);
    }

    @Override
    public void update(Dimension size) {
        bounds.x += xDelta;
        bounds.y += yDelta;

        if (bounds.x < 0) {
            bounds.x = 0;
            xDelta *= -1;
        } else if (bounds.x + bounds.width > size.width) {
            bounds.x = size.width - bounds.width;
            xDelta *= -1;
        }
        if (bounds.y < 0) {
            bounds.y = 0;
            yDelta *= -1;
        } else if (bounds.y + bounds.height > size.height) {
            bounds.y = size.height - bounds.height;
            yDelta *= -1;
        }
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fill(bounds);
    }

}
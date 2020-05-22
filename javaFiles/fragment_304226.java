public class Ping {

    private Point point;
    private Point from;
    private Point to;
    private Color fillColor;

    private Shape dot;

    public Ping(Point from, Point to, Color fillColor) {
        this.from = from;
        this.to = to;
        this.fillColor = fillColor;
        point = new Point(from);

        dot = new Ellipse2D.Double(0, 0, 6, 6);
    }

    public void paint(Container parent, Graphics2D g2d) {
        Graphics2D copy = (Graphics2D) g2d.create();
        int width = dot.getBounds().width / 2;
        int height = dot.getBounds().height / 2;
        copy.translate(point.x - width, point.y - height);
        copy.setColor(fillColor);
        copy.fill(dot);
        copy.dispose();
    }

    public Rectangle getBounds() {
        int width = dot.getBounds().width;
        int height = dot.getBounds().height;

        return new Rectangle(point, new Dimension(width, height));
    }

    public void update(double progress) {
        int x = update(progress, from.x, to.x);
        int y = update(progress, from.y, to.y);

        point.x = x;
        point.y = y;
    }

    protected int update(double progress, int from, int to) {
        int distance = to - from;
        int value = (int) Math.round((double) distance * progress);
        value += from;
        if (from < to) {
            value = Math.max(from, Math.min(to, value));
        } else {
            value = Math.max(to, Math.min(from, value));
        }

        return value;
    }
}
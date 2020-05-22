public class Ball {

    private Shape shape;
    private Point p;

    public Ball() {
        shape = new Ellipse2D.Float(0, 0, 10, 10);
    }

    public void setLocation(Point p) {
        this.p = p;
    }

    public Point getLocation() {
        return p;
    }

    public Shape getShape() {
        return shape;
    }

    public void paint(Graphics2D g2d) {
        Point p = getLocation();
        if (p != null) {
            g2d = (Graphics2D) g2d.create();
            g2d.setColor(Color.BLUE);
            Shape shape = getShape();
            int x = (int) p.x - (shape.getBounds().width / 2);
            int y = (int) p.y - (shape.getBounds().height / 2);
            g2d.translate(x, y);
            g2d.fill(shape);
            g2d.dispose();
        }
    }

    public int getWidth() {
        return getShape().getBounds().width;
    }

    public int getHeight() {
        return getShape().getBounds().width;
    }
}
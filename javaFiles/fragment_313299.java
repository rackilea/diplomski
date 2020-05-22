public class RandomShape {

    private final Color color;
    private final Shape shape;

    public RandomShape(Color color, Shape shape) {
        this.color = color;
        this.shape = shape;
    }

    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.draw(shape);
        g2d.fill(shape);
    }

}
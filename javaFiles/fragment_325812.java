public class Compound
{
    private List<Shape> shapes;

    public Compound() {
        shapes = new ArrayList<Shape>(25);
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public Iterable<Shape> getShapes() {
        return shape;
    }

    public void draw(Graphics g) {
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}
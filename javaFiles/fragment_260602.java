public class Example {
    private List<Rectangle> rectangles = new ArrayList<>();

    public void addRectangle(double x, double y, double width, double height) {
        rectangles.add(new Rectangle(x, y, width, height));
    }

    public Rectangle getRectangle(int index) {
        return rectangles.get(index);
    }
}
public class Rectangle extends Shape {

    private final double width, height, area, perimeter;

    public Rectangle(final double width, final double height) {
        this.width = width;
        this.height = height;
        this.area = width * height;
        this.perimeter = 2 * (width + height);
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public double getPerimeter() {
        return this.perimeter;
    }

    @Override
    public double area() {
        return getArea();
    }

    @Override
    public double perimeter() {
        return getPerimeter();
    }
}
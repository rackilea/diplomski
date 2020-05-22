public interface Shape {
    double getPerimeter();
    double getArea();
}

public static class PerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape a, Shape b) {
        return Double.compare(a.getPerimeter(), b.getPerimeter());
    }
}

public static class AreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape a, Shape b) {
        return Double.compare(a.getArea(), b.getArea());
    }
}

public static class Circle implements Shape {
    private final double x, y, r;

    @Override
    public double getPerimeter() {
        return 2 * (3.14) * r;
    }

    @Override
    public double getArea() {
        return 3.14 * r * r;
    }

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }
}

public static class Square implements Shape{
    private final double x, y, a;

    @Override
    public double getPerimeter() {
        return 4 * a;
    }

    @Override
    public double getArea() {
        return a * a;
    }

    public Square(double x, double y, double a) {
        this.x = x;
        this.y = y;
        this.a = a;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getA() {
        return a;
    }
}


public static void main(String[] args) {
    List<Shape> shapes = new ArrayList<>();
    List<Circle> circles = new ArrayList<>();
    circles.add(new Circle(0.0,0.0,1.0));
    circles.add(new Circle(1.0,0.0,2.0));
    circles.add(new Circle(0.0,2.0,4.0));
    circles.add(new Circle(1.0,3.0,1.0));

    Circle largestCircle = Collections.max(circles, new PerimeterComparator());

    System.out.println("The circle with the biggest circumference has:\n");
    System.out.println("x-axis value: " + largestCircle.getX() + " y-axis value: " + largestCircle.getY() + " radius: " + largestCircle.getPerimeter() +"\n");

    List<Square> squares = new ArrayList<>();
    squares.add(new Square(0.0,0.0,1.0));
    squares.add(new Square(0.0,0.0,1.0));
    squares.add(new Square(0.0,0.0,5.0));
    squares.add(new Square(4.0,2.0,2.0));
    squares.add(new Square(0.0,0.0,1.0));

    Square largestSquare = Collections.max(squares, new PerimeterComparator());

    System.out.println("The square with the biggest area has:\n");
    System.out.println("x-axis value: " + largestSquare.getX() + " y-axis value: " + largestSquare.getY() + " side: " + largestSquare.getA());

    shapes.addAll(circles);
    shapes.addAll(squares);

    Shape largestPerimeter = Collections.max(shapes, new PerimeterComparator());
    Shape largestArea      = Collections.max(shapes, new AreaComparator());

    System.out.printf("\nThe shape with the biggest perimeter is a %s and has has: a perimeter of: %f\n", largestPerimeter.getClass().getSimpleName(), largestPerimeter.getPerimeter());
    System.out.printf("The shape with the biggest area is a %s and has has: an area of: %f\n", largestArea.getClass().getSimpleName(), largestArea.getArea());
}
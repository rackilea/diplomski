public class ShapeExample implements EntryPoint {
  private static final double SIDE_LEN_SMALL = 2;
  private final Shape shape = new SmallSquare();
  public static abstract class Shape {
    public abstract double getArea();
  }
  public static abstract class Square extends Shape {
    public double getArea() { return getSideLength() * getSideLength(); }
    public abstract double getSideLength();
  }
  public static class SmallSquare extends Square {
    public double getSideLength() { return SIDE_LEN_SMALL; }
  }
  public void onModuleLoad() {
    Shape shape = getShape();
    Window.alert("Area is " + shape.getArea());
  }
  private Shape getShape() { return shape; }
}
public class Circle extends Shape {
  @Override
  public double getArea() {
    return length * length * Math.PI;
  }
  @Override
  public double getBoundaryLength() {
    return 2 * length * Math.PI;
  }
}
public abstract class Shape {
    protected double length;
    public Shape(double length) {
      this.length = length;
    }
    public abstract double getArea();
    public abstract double getBoundaryLength();
}
public abstract class Polygon {

  protected double area; //not private, we want sub-classes to see this field

  public Polygon(double area) {
    this.area = area;
  }

  public abstract double getPerimiter();
}
public class Square extends Polygon {

  public Square(double area) {
    super(area);
  }

  public double getPerimiter() {
    return Math.sqrt(area) * 4;
  }

}
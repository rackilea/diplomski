public class Line extends Shape {
    private Point firstPoint;
    private Point secondPoint;

    public Line(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    @Override
    boolean contains(Point point) {
       return (distance(firstPoint, point) + distance(secondPoint, point) == distance(firstPoint, secondPoint));
    }

}
public class Circle {
    private double radius;

    public Circle(Double radius) { this.radius = radius;}

    public double getArea() { return radius*radius*Math.PI; }
    public double getRadius() { return radius;}
    public double getDiameter() { return 2*radius;}
    public double getCircumference() { return Math.PI*getDiameter();}
}
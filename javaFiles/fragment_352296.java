public double pi = 3.14, l, radius, height; // , area, volume;

public static class RoundShape extends Base_HW04Q1 {
    public RoundShape(double radius) {
        this.radius = radius;
    }
    public double calcArea () {
        return (radius * radius) * pi;
        // return area;
    }
    public String toString() {
        return "A Round Shape of radius: " + radius + ", area " + calcArea() + ".";
    }
}
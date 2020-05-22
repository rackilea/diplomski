class Cylinder inherits GeoFig {

    private final double height;
    private final double radius;

    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    public double getHeight() {
        return this.height;
    }

    public double getRadius() {
        return this.radius;
    }

    double getVolume() {
        return 0;
    }
}
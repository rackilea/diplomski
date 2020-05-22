public class PolygonShape implements Shape {

    private final ShapeType type = ShapeType.Polygon;
    private double[][][] coordinates;

    public ShapeType getType() {
        return type;
    }

    public double[][][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[][][] coordinates) {
        this.coordinates = coordinates;
    }
}
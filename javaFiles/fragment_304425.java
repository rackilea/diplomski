public class MultiPolygonShape implements Shape {

    private final ShapeType type = ShapeType.MultiPolygon;
    private double[][][][] coordinates;

    public ShapeType getType() {
        return type;
    }

    public double[][][][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[][][][] coordinates) {
        this.coordinates = coordinates;
    }
}
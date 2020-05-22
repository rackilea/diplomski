public interface Shape {

    ShapeType getType();

    enum ShapeType { Polygon, MultiPolygon }
}
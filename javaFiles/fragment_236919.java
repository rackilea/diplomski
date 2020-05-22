public interface ShapeVisitor<P, R> { 
    R visitRect(Rect rect, P param);
    R visitLine(Line line, P param);
    R visitText(Text text, P param);
}

public interface Shape {
    <P, R> R accept(P param, ShapeVisitor<? super P, ? extends R> visitor);
    Shape intersectionWith(Shape shape);
}

public class Rect implements Shape {

    public <P, R> R accept(P param, ShapeVisitor<? super P, ? extends R> visitor) {
        return visitor.visitRect(this, param);
    }

    public Shape intersectionWith(Shape shape) {
        return shape.accept(this, RectIntersection);
    }

    public static ShapeVisitor<Rect, Shape> RectIntersection = new ShapeVisitor<Rect, Shape>() {
        public Shape visitRect(Rect otherShape, Rect thisShape) {
            // TODO...
        }
        public Shape visitLine(Line otherShape, Rect thisShape) {
            // TODO...
        }
        public Shape visitText(Text otherShape, Rect thisShape) {
            // TODO...
        }
    };
}
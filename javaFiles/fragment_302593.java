public interface ShapeFactory {
    public Shape make(String shapeType);
}

public class ShapeFactoryImpl implements ShapeFactory {
    private int circleRadius;
    private int rectangleLength;
    private int rectangleBreadth;

    public ShapeFactoryImpl(int circleRadius, int rectangleLength, int rectangleBreadth){
        this.circleRadius = circleRadius;
        this.rectangleLength = rectangleLength;
        this.rectangleBreadth = rectangleBreadth;
    }

    public Shape make(String shapeType) {
        switch (shapeType) {
            case "Circle": return new Circle(this.circleRadius); 
            case "Rectangle": return new Rectangle(this.rectangleLength, this.rectangleBreadth);
            default: throw new Exception("..."); 
        }
    }
}
public class ShapeFactoryImpl implements ShapeFactory {
    private Shape circle;
    private Shape rectangle;

    public ShapeFactoryImpl(Circle circle, Rectangle rectangle){
        this.circle = circle;
        this.rectangle = rectangle;
    }

    public Shape make(String shapeType) {
        switch (shapeType) {
            case "Circle": return this.circle.clone(); 
            case "Rectangle": return this.rectangle.clone();
            default: throw new Exception("..."); 
        }
    }
}
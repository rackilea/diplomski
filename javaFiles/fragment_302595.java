public class ShapeFactoryImpl implements ShapeFactory {
    private Map<String, Shape> shapeByType;

    public ShapeFactoryImpl(Map<String, Shape> shapeByType){
        this.shapeByType = shapeByType;
    }

    public Shape make(String shapeType) {
        Shape shape = this.shapeByType.get(Type).clone();
        if (shape == null) {
            throw new Exception("...");
        }
        return shape;
    }
}
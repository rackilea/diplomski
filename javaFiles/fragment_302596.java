public class ShapeFactoryImpl implements ShapeFactory {
    private EnumMap<ShapeType, Shape> shapeByType;

    public ShapeFactoryImpl(Map<ShapeType, Shape> shapeByType){
        this.shapeByType = shapeByType;
    }

    public Shape make(ShapeType shapeType) {
        return this.shapeByType.get(Type).clone();
    }
}
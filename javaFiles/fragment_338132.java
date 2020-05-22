interface Slicer<T extends Serializable> {
    Optional<Map<String, T>> pointer();
}
abstract class DynamoDbSlicer implements Slicer<AttributeValue> {
    @Override
    public abstract Optional<Map<String, AttributeValue>> pointer();
}
interface Slicer {
    Map<String, ? extends Serializable> pointer();
}
abstract class DynamoDbSlicer implements Slicer {
    @Override
    public abstract Map<String, Serializable> pointer();
}
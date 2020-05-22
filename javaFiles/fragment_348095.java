public enum DataType<T> {
    TRANSPARENT<Boolean>(Boolean.class),
    PASSABLE<Boolean>(Boolean.class),
    PASSAGE_COST<Integer>(Integer.class);

    private Class<T> type;

    private DataType<T>(Class<T> type) { this.type = type; }

    public Class<T> getType() { return type; }
}

public class DataTypeMap {
    private Map<DataType<?>, Object> map = new HashMap<DataType<?>, Object>();

    public <T> void put(DataType<T> dataType, T value) {
        map.put(dataType, value);
    }

    public <T> T get(DataType<T> dataType) {
        Object value = map.get(dataType);
        return dataType.getType().cast(value);
    }
}

public void someMethod() {
    DataTypeMap  map = new DataTypeMap();
    map.put(DataType.TRANSPARENT, true);
    map.put(DataType.PASSAGE_COST, 12345);
    map.put(DataType.PASSAGE_COST, "some string"); // compile error

    boolean flag = map.get(DataType.TRANSPARENT);
    int number = map.get(DataType.PASSAGE_COST);
    String string = map.get(DataType.PASSAGE_COST); // compile error
}
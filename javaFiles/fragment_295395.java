public abstract class DataType<T> {
    <T> T fromString(String data);
}

public final static DataType<Boolean> BOOLEAN = new DataType<Boolean>() {
    Boolean fromString(String data) {
        ...
    }
};

// ...

Data data = ...
Object value = data.getType().fromString(data.getContent())
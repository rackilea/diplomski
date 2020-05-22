public class Record<T> {
    private T value;
    private Class<T> meta;

    public Record(T value, Class<T> meta) {
        //Initialization
    }

    public Class<T> getMeta() {
        return meta;
    }
}
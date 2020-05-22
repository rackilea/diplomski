public interface EventType {
    // common functionality of EventTypes, if any
}

public interface AttributeType {
    // common functionality of AttributeTypes , if any
}

public class GameEvent<T extends EventType, S extends AttributeType> {
    private HashMap<S, String> values;
    private T type;

    public void init(T type) {
        this.type = type;
    }

    public T getType() {
        return this.type;
    }

    public void addMessage(S t, String value) {
        this.values.put(t, value);
    }

    public void getMessage(S t) {
        this.values.get(t);
    }
}
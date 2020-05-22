public class KeyValueElement<T> {

    private String key;

    private T value;

    @SuppressWarnings("unchecked")
    @JsonCreator
    public KeyValueElement(Map<String, Object> delegate) {
        this.key = (String) delegate.get("key");
        this.value = (T) delegate.get("value");
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
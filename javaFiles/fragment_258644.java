@SuppressWarnings("serial")
public class KeyValue<T>
    extends LinkedList<KeyValueElement<T>> {

    public KeyValue() {
    }

    public KeyValue(String key, T value) {
        Map<String, Object> map = new HashMap<>(1);
        map.put(key, value);
        KeyValueElement<T> elem = new KeyValueElement<>(map);
        this.add(elem);
    }
}
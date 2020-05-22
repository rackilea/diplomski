public class Something<T> {
    private T key;

    public Something(T key) {
        this.key = key;
    }

    public <V> V getValueForKey(Map<T, V> map) {
        return map.get(key);
    }
}
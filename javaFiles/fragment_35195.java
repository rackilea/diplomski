import java.util.LinkedHashMap;
import java.util.Map;

class CustomHashMap<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public CustomHashMap(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
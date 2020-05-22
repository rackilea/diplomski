import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class MultiMap<K, V> {
    Map<K, List<V>> map = new HashMap<K, List<V>>();

    public void put(K key, V value) {
        List<V> values = null;
        if(!map.containsKey(key)) {
            values = new LinkedList<V>();
            map.put(key, values);
        } else {
            values = map.get(key);
        }

        assert(values != null);
        values.add(value);
    }

    public List<V> get(K key) {
        return map.get(key);
    }
}
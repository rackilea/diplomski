public class MapTransformer<K,V> implements Transformer<K,V> {

    private final Map<K,V> map;

    public MapTransformer(Map<K,V> map) {
      this.map = map;
    }

    public V transform(K key) {
      return map.get(key);
    }

  }
@Override
public V put(final K key, final V value) {
    V v = values.get(value);
    if (v == null) {
        v = value
        values.put(v, v);
    } 
    return super.put(key, v);
}
public static final class Value {
    private final Object value;
    private Value(Object o) { value=o; }
}
public static Value value(int i) {
    // you could verify the range here
    return new Value(i);
}
public static Value value(String s) {
    // could reject null or invalid string contents here
    return new Value(s);
}
// these helper methods may be superseded by Java 9’s Map.of(...) methods
public static <K,V> Map<K,V> map(K k, V v) { return Collections.singletonMap(k, v); }
public static <K,V> Map<K,V> map(K k1, V v1, K k2, V v2) {
    final HashMap<K, V> m = new HashMap<>();
    m.put(k1, v1);
    m.put(k2, v2);
    return m;
}
public static <K,V> Map<K,V> map(K k1, V v1, K k2, V v2, K k3, V v3) {
    final Map<K, V> m = map(k1, v1, k2, v2);
    m.put(k3, v3);
    return m;
}
public void setProperties(Map<String, Value> properties) {
    Map<String,Object> actual;
    if(properties.isEmpty()) actual = Collections.emptyMap();
    else {
        actual = new HashMap<>(properties.size());
        for(Map.Entry<String, Value> e: properties.entrySet())
            actual.put(e.getKey(), e.getValue().value);
    }
    // proceed with actual map

}
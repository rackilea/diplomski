public class GenericClass<K, V> implements MyInterface<K, V> {
    private final Map<K, V> myMap;
    private final Class<K> keyClass;
    private final Class<V> valueClass

    public GenericClass(Class<K> keyClass, Class<V> valueClass) {
        this.myMap = new HashMap<K, V>();
    }

    public Class<K> getKeyClass() { return keyClass; }
    public Class<V> getValueClass() { return valueClass; }
public static class MyMap<K, V> extends HashMap<K, V> {
    private Class<?> clazz;

    public MyMap(Class<?> clazz) {
        this.clazz = clazz;
    }

    public V getOrCompute(K key) {
        V v = get(key);
        if(v == null) {
            try {
                v = (V) clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            put(key, v);
        }
        return v;
    }
}
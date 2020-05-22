public static interface Supplier<T> {

    T get();
}

public static class DelegatingMap<K, V> implements Map<K, V> {

    private final Map<K, V> backingMap;

    public DelegatingMap(final Supplier<Map<K, V>> backingMapSupplier) {
        backingMap = backingMapSupplier.get();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //etc...
}
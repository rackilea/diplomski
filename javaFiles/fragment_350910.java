public class MyHashMap<K, V> extends HashMap {
    @Override
    public Boolean put(Object key, Object value) {
        try {
            super.put(key, value);
        } catch (UnsupportedOperationException | ClassCastException | NullPointerException | IllegalArgumentException e) {
            return false; // or do what you want!
        }
        return true;
    }
}
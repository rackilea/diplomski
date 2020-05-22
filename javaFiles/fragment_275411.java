public class SaltedHashMap<V> {
    private final Map<String, V> map = new HashMap<>();
    private final String salt;
    public SaltedHashMap(String salt) {
        this.salt = salt;
    }
    public V get(String key){
        return map.get(key + salt);
    }
    public void put(String key, V value) {
        map.put(key + salt, value);
    }
}
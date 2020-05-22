package persistence;

public interface Repository<K, V> {
    List<V> find();
    V find(K id);
    List<V> find(Predicate<V> filter); 
    void save(V v);
    void update(V v);
    void delete(K id);
    void delete(V v);
}
public class Multiton<K extends Enum<K> & Multiton.Creator> {

    private final ConcurrentMap<K, Object> multitons = new ConcurrentHashMap<>();

    // The enums must create
    public interface Creator {

        public abstract Object create();

    }

    // The getter.
    public <V> V get(final K key, Class<V> type) {
        return type.cast(multitons.computeIfAbsent(key, k -> k.create()));
    }
}
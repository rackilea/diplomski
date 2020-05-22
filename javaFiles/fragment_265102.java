public class WeakHashMap<K,V> implements Map<K,V> {

private static class Entry<K,V> extends WeakReference<K> 
  implements Map.Entry<K,V> {
    private V value;
    private final int hash;
    private Entry<K,V> next;
    ...
}

public V get(Object key) {
    int hash = getHash(key);
    Entry<K,V> e = getChain(hash);
    while (e != null) {
        K eKey= e.get();
        if (e.hash == hash && (key == eKey || key.equals(eKey)))
            return e.value;
        e = e.next;
    }
    return null;
}
public class RxCache<K, V> {

    final ConcurrentHashMap<K, AsyncSubject<V>> cache;

    final Func1<K, Observable<V>> valueGenerator;

    public RxCache(Func1<K, Observable<V>> valueGenerator) {
        this.valueGenerator = valueGenerator;
        this.cache = new ConcurrentHashMap<>();
    }

    public Observable<V> get(K key) {
        AsyncSubject<V> o = cache.get(key);
        if (o != null) {
            return o;
        }

        o = AsyncSubject.create();

        AsyncSubject<V> p = cache.putIfAbsent(key, o);
        if (p != null) {
            return p;
        }

        valueGenerator.call(key).subscribe(o);

        return o;
    }

    public void remove(K key) {
        cache.remove(key);
    }
}
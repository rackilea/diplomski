public final class ReactiveCache<K, V> {
    final Map<K, Observable<V>> requests = new HashMap<>();

    final Function<K, Observable<V>> generator;

    public ReactiveCache(Function<K, Observable<V>> generator) {
        this.generator = generator;
    }

    public Observable<V> get(K key) {
        ConnectableObservable<V> result;
        synchronized (requests) {
            Observable<V> current = requests.get(key);
            if (current != null) {
                return current;
            }

            result = generator.apply(key)
                    .doOnTerminate(() -> {
                        synchronized (requests) {
                            requests.remove(key);
                        }
                    })
                    .replay();

            requests.put(key, result);
        }

        return result.autoConnect(0);
    }
}
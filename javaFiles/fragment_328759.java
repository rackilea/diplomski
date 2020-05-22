LoadingCache<K, V> cache = CacheBuilder.newBuilder()
        .refreshAfterWrite(15, TimeUnit.MINUTES)
        .maximumSize(100)
        .build(new MyCacheLoader());

for (K key : cache.asMap().keySet()) {
    cache.refresh(key);
}
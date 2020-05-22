public static void main(String[] args) throws IgniteException {
    Ignite ignite = Ignition.start("examples/config/example-ignite.xml");

    IgniteCache<Integer, String> atomicCache = ignite.getOrCreateCache(
        cacheConfiguration("atomic", CacheAtomicityMode.ATOMIC));

    IgniteCache<Integer, String> txCache = ignite.getOrCreateCache(
        cacheConfiguration("transactional", CacheAtomicityMode.TRANSACTIONAL));

    atomicCache.invoke(1, (entry, arguments) -> {
        System.out.println("Atomic invoke");
        return null;
    });

    txCache.invoke(1, (entry, arguments) -> {
        System.out.println("Transactional invoke");
        return null;
    });
}

private static <K, V> CacheConfiguration<K, V> cacheConfiguration(String name, CacheAtomicityMode atomicity) {
    CacheConfiguration<K, V> cacheCfg = new CacheConfiguration<>(name);
    cacheCfg.setAtomicityMode(atomicity);
    cacheCfg.setCacheMode(CacheMode.REPLICATED);
    cacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);

    return cacheCfg;
}
public Cache<Integer, List<Application>> getMyCacheManager(CacheManager manager) {
    Cache<Integer, List<Application>> cache = manager.getCache("myCache");
    if (Objects.isNull(cache)) {
        var config = new MutableConfiguration<Integer, List<Application>>()
                .setTypes(Integer.class, List.class)
                .setStoreByValue(false)
                .setStatisticsEnabled(true)
                .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(TimeUnit.MILLISECONDS, myCacheExpiry)));
        cache = (Cache<Integer, List<Application>>) ((Object) manager.createCache("myCache", config));
    }
    return cache;
}
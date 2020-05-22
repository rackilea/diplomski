MutableConfiguration<String, LinkedHashMap> config = new MutableConfiguration<String, LinkedHashMap>()
         .setTypes(String.class, LinkedHashMap.class);
CachingProvider provider = Caching.getCachingProvider();
CacheManager defaultCacheManager = provider.getCacheManager();
Cache<String, LinkedHashMap> cache = defaultCacheManager
        .createCache("cache", config);
@Autowired
CacheManager cacheManager;

public void evictAll() {
    cacheManager.getCacheNames()
            .stream()
            .forEach(n -> cacheManager.getCache(n).clear());
}
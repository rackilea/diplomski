@Cacheable("myCache")
public String getCache() {
    try {
        Thread.sleep(3000);
    } catch (final InterruptedException e) {
    }
    return "aaa";
}

@CacheEvict(cacheNames = "myCache", allEntries = true)
public void evictAll() {
}
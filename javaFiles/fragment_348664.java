@Autowired
public ClearCacheTask(final @NotNull CacheManager cacheManager) {
  this.cacheManager = cacheManager;
}

@Scheduled(cron="0 0 0 * * ?")
@Async
public void resetCacheMidnight() {
  logger.info("Cron Task resetCacheMidnight(), clearing following caches...");

  cacheManager.getCacheNames().parallelStream().forEach(name ->  {
    cacheManager.getCache(name).clear();

    logger.info("...{} cache cleared", name);
  });      
}
@PostConstruct
  private void refreshCache() {
    /* Refresh cache concurrently */    
    Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(
                () -> resellersCache.refresh(this.getClass().toString()), 33,
                cacheRefreshTimeInterval, TimeUnit.SECONDS);
  }
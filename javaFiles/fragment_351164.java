final Runnable doCleanup = new Runnable() {
    public void run() { 
        LoadingCache<K, V> cache = getCache();
        cache.cleanUp();
        }
    }

ScheduledFuture<?> cleanupHandle = scheduler.scheduleAtFixedRate(doCleanup, 1, 1, TimeUnit.MINUTES);
return cleanupHandle;
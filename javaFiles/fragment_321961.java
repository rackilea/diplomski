class YourCache {

  // holds the last time the cache has been refreshed in millis
  private volatile long lastRefreshDate;

  // indicates that cache is currently refreshing entries
  private volatile boolean cacheCurrentlyRefreshing;

  private Map cache = // Your concurrent map cache...

  public void put(Object key, Object element) {
    if (cacheNeedsRefresh()) {
      refresh();
    }
    map.put(key, element);
  }

  public Object get(Object key) {
    if (cacheNeedsRefresh()) {
      refresh();
    }
    return map.get(key);
  }

  private boolean cacheNeedsRefresh() {
    // make sure that cache is not currently being refreshed by some
    // other thread.
    if (cacheCurrentlyRefreshing) {
      return false;
    }
    return (now - lastRefreshDate) >= REFRESH_INTERVAL;
  } 

  private void refresh() {
    // make sure the cache did not start refreshing between cacheNeedsRefresh()
    // and refresh() by some other thread.
    if (cacheCurrentlyRefreshing) {
      return;
    }

    // signal to other threads that cache is currently being refreshed.
    cacheCurrentlyRefreshing = true;

    try {
      // refresh your cache contents here
    } finally {
       // set the lastRefreshDate and signal that cache has finished
       // refreshing to other threads.
       lastRefreshDate = System.currentTimeMillis();
       cahceCurrentlyRefreshing = false;
    }
  }
}
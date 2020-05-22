public boolean contains(String cacheName, Object o) {
  net.sf.ehcache.EhCache cache = (net.sf.ehcache.EhCache) org.springframework.cache.CacheManager.getCache(cacheName).getNativeCache();
  for (Object key: cache.getKeys()) {
    Element element = cache.get(key);
    if (element != null && element.getObjectValue().equals(o)) {
      return true;
    }
  }
  return false;
}
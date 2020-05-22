class MyCache {
  private final Map<CacheHelper<?>, Object> backingMap = new HashMap<>();
  public <T> void put(CacheHelper<T> key, T value) {
    backingMap.put(key, value);
  }
  @SuppressWarnings("unchecked")
  // as long as all entries are put in via put, the cast is safe
  public <T> T get(CacheHelper<T> key) {
    return (T) backingMap.get(key);
  }
}
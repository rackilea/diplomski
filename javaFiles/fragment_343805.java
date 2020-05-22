public Page getPage(Integer id) {
  Page p = cache.get(id);
  if (p == null) {
    synchronized (getCacheSyncObject(id)) {
      p = getFromDataBase(id);
      cache.store(p);
    }
  }
}

private ConcurrentMap<Integer, Integer> locks = new ConcurrentHashMap<Integer, Integer>();

private Object getCacheSyncObject(final Integer id) {
  locks.putIfAbsent(id, id);
  return locks.get(id);
}
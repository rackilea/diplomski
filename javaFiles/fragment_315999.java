static class MetricsEntry {

  long nextUpdate;
  List<Metrics> metrics;

}

static class MyEntryExpiryCalculator implements EntryExpiryCalculator<Integer, MetricsEntry> {
  @Override
  public long calculateExpiryTime(Integer _key, MetricsEntry _value, long _fetchTime, CacheEntry _oldEntry) {
    return _value.nextUpdate;
  }
}

Cache createTheCache() {
  Cache<Integer, MetricsEntry> cache =
    CacheBuilder.newCache(Integer.class, MetricsEntry.class)
      .sharpExpiry(true)
      .entryExpiryCalculator(new MyEntryExpiryCalculator())
      .source(new MySource())
      .build();
   return cache;
}
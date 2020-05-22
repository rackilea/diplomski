static class MySource implements CacheSource<Integer, MetricsEntry> {
  @Override
  public MetricsEntry get(Integer interval)  {
    MetricsEntry e = new MetricsEntry();
    boolean crossedIntervalEnd;
    do {
      long now = System.currentTimeMillis();
      long intervalMillis = interval * 1000 * 60;
      long startOfInterval = now % (intervalMillis);
      e.metrics = calculateMetrics(startOfInterval, interval);
      e.nextUpdate = startOfInterval + intervalMillis;
      now = System.currentTimeMillis();
      crossedIntervalEnd = now >= e.nextUpdate;
    } while (crossedIntervalEnd);
    return e;
  }
}
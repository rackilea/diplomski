static class MySource implements CacheSource<Integer, MetricsEntry> {
  @Override
  public MetricsEntry get(Integer interval)  {
    MetricsEntry e = new MetricsEntry();
    long intervalMillis = interval * 1000 * 60;
    long startOfInterval = System.currentTimeMillis();
    e.metrics = calculateMetrics(startOfInterval, interval);
    e.nextUpdate = startOfInterval + intervalMillis;
    return e;
  }
}
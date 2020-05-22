private static Runnable loadMetrics = MetricsProcessor::processMetrics;
private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

static {
    loadMetrics.run();
    // Note the updated initial delay. 
    executor.scheduleAtFixedRate(loadMetrics, 10, 10, TimeUnit.SECONDS);
}
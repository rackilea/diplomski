public abstract class FlushingCache<T> {

  private final Duration maxDuration;
  private final int maxSize;
  private final List<T> queue = new ArrayList<>();
  private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

  public FlushingCache(Duration maxDuration, int maxSize) {
    this.maxDuration = maxDuration;
    this.maxSize = maxSize;
    executor.scheduleWithFixedDelay(this::doFlush,
        maxDuration.getSeconds(),
        maxDuration.getSeconds(),
        TimeUnit.SECONDS);
  }

  public synchronized void enqueue(T element) {
    println("Enqueueing element " + element);
    queue.add(element);
    if (queue.size() >= maxSize) {
      doFlush();
    }
  }

  private synchronized void doFlush() {
    List<T> batch = new ArrayList<>(queue);
    println("Flushing batch " + batch);
    flush(batch);
    queue.clear();
  }

  // The login of flushing to DB will be implemented in the sub-classes
  protected abstract void flush(List<T> batch);
}
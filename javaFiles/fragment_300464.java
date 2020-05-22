@Component
public class StudentFlushingCache {

  private final List<T> queue = new ArrayList<>();

  @Value("${student.flushing-cache.max-size}")
  private final int maxSize;

  @Scheduled(
      fixedDelayString = "${student.flushing-cache.fixed-delay}",
      initialDelayString = "${student.flushing-cache.initial-delay}")
  public void flushPeriodically() {
     doFlush();
  }

  public synchronized void enqueue(T element) {
    /* ... */
  }

  private synchronized void doFlush() {
    /* ... */
  }
}
public class Worker implements Runnable {

   private static final Metrics metrics = new Metrics();

   public void run() {
      while (true) {
        ...get record
        long start = System.currentTimeMillis();
        ...do work
        long end = System.currentTimeMillis();
        // process the metric asynchronously
        metrics.addMetric(end - start);
     }
  }

  private static final class Metrics {
     // a single "background" thread that actually handles
     // processing
     private final ExecutorService metricThread = 
           Executors.newSingleThreadExecutor();
     // data (no synchronization needed)
     private int count = 0;
     private long processingTime = 0;

     public void addMetric(final long time) {
        metricThread.execute(new Runnable() {
           public void run() {
              count++;
              processingTime += time;
              if (count % 1000 == 0) {
                 ... log some metrics
                 processingTime = 0;
                 count = 0;
              }
           }
        });
      }
   }
}
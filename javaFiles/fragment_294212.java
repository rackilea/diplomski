import java.util.concurrent.*;

public class URLConnectionReader {
  public static void main(String... args) {
    NewsTask task = new NewsTask();

    ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
    service.scheduleAtFixedRate(task, 0L, 20L, TimeUnit.SECONDS);
  }
}
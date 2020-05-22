import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Executors;

final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);
// Execute a task after 5 seconds
scheduler.schedule(() -> new Result("Name", 4), 5, TimeUnit.SECONDS);
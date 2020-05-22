import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class MyExecutor implements Executor {

  private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
  private final Thread thread = new Thread(() -> {
    try {
      while (!Thread.interrupted()) {
        queue.take().run();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }, "my-executor-thread");

  @Override
  public void execute(Runnable command) {
    Objects.requireNonNull(command);
    queue.add(command);
    synchronized (thread) {
      if (thread.getState() == Thread.State.NEW) {
        thread.start();
      }
    }
  }

}
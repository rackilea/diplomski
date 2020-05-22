public abstract class AbstractWidget implements Runnable {
  // Other fields and methods omitted for brevity.
  private volatile boolean running = false;
  private valatile boolean stopped = false;

  public boolean isRunning() {
    return running;
  }

  public boolean hasStopped() {
    return stopped;
  }

  public void shutDown() {
    stopped = true;
  }
}

public class ConcreteWidget extends AbstractWidget {
  // Other fields and methods omitted for brevity.

  @Override
  public void run() {
    running = true;
    while (!stopped) {
      // ...
    }
    running = false;
    logger.info("Shutting down");
  }
}
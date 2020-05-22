abstract class Pausable implements Runnable {

  private final Object lock = new Object();

  private boolean pause = false;

  abstract void doSomething();

  @Override
  public void run() {
    while (cantering()) doSomething();
  }

  private boolean cantering() {
    synchronized (lock) {
      while (pause) {
        try { lock.wait(); }
        catch (InterruptedException ex) { 
          Thread.currentThread().interrupt();
          return false;
        }
      }
    }
    return true;
  }

  final void whoa() {
    synchronized(lock) {
      pause = true;
    }
  }

  final void giddyup() {
    synchronized(lock) {
      pause = false;
      lock.notify();
    }
  }

}
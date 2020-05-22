abstract class ChainThread extends Thread {

  private final Thread next;

  ChainThread(Thread next) { this.next = next; }

  @Override
  public final void run() {
    next.start();
    while (!Thread.currentThread().isInterrupted() && next.isAlive()) {
      do();
    }
  }

  abstract void do();

}
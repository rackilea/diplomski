// can be used for multiple Threads
class StatelessRunnable {
  public void run() {
    doSomething();
  }
}

// may go bang on the second execution -> use two instances
class StatefulRunnable {
  volatile boolean canRun = true;
  public void run() {
    if(!canRun) throw new IllegalStateException();
    canRun = false;
  }
}
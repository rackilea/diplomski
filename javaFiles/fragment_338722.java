class MyRunnable implements Runnable {
  private final Semaphore sem;

  public MyRunnable(Semaphore sem) {
    this.sem = sem;
  }

  public void run() {
    // do work

    // signal complete
    sem.release()
  }
}
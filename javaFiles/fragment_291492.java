class Thread2 extends Thread {

  boolean taskCompleted = false;

  public void run() {
    /* It executes a complex task... */
    synchronized (this) {
      taskCompleted = true;
      notifyAll(); // notify waiting threads
    }
  }
}
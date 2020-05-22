class RunnableDecorator implements Runnable {

  private final Runnable delegate;

  // this task counter must be increased on any 
  // scheduling of a task by the thread pool
  private final AtomicInteger taskCounter;

  // Constructor omitted

  @Override
  public void run() {
    try {
      delegate.run();
    } finally {
      if (taskCounter.decrementAndGet() == 0) {
        // spawn idle action
      }
    }
  }
}
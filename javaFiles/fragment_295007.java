Executor executor = // ...
final int permits = // ...
final Semaphore semaphore = new Semaphore(permits);

void schedule(final Runnable task) {
  semaphore.acquire();
  try {
    executor.execute(new Runnable() {
      @Override public run() {
        try {
          task.run();
        } finally {
          semaphore.release();
        }
      }
    });
  } catch (RejectedExecutionException e) {
    semaphore.release();
    throw e;
  }
}

void shutDown() {
  semaphore.acquireUninterruptibly(permits);

  // do stuff
}
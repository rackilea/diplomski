// Thread pool for the collectors.
ExecutorService threads = Executors.newFixedThreadPool(MAX_THREADS);
...
// Futures of all collectors running in the pool.
ConcurrentLinkedQueue<Future> collectors = new ConcurrentLinkedQueue<Future>();
...
// Make my Callable.
Callable<Void> c = new FileListCollector(path, recurse, filter);
// Start it up and keep track of it so we can find out when it has finished.
collectors.add(threads.submit(c));
...

// Called when nothing in queue.
private void checkForFinished() {
  // Count the running threads.
  int runningThreads = 0;
  try {
    // Track dead ones to remove.
    List<Future> deadThreads = new LinkedList<Future>();
    // Walk all collectors.
    for (Future f : collectors) {
      // I've seen f being null once. No idea how.
      if (f != null) {
        // If it's not done then it's running.
        if (!f.isDone()) {
          // Count it.
          runningThreads += 1;
        } else {
          // Mark for deletion.
          deadThreads.add(f);
        }
      }
    }
    // Clear dead threads - just to be tidy.
    collectors.removeAll(deadThreads);
  } catch (ConcurrentModificationException cme) {
    // Probably a new thread has been started while I was checking!
    // Therefore almost certainly NOT all finished.
    runningThreads += 1;
  }
  // If no threads are left, we're done.
  if (runningThreads == 0) {
    // Finished! Close everything down.
    close();
  }
}

// Close down the whole system.
public void close() {
  // Use the fileQueue state to indicate closed.
  if (!fileQueue.isClosed()) {
    // Close the queue ... unblocking all collectors (I hope).
    fileQueue.close();
    // Shut them down agressively as this may be called by user prematurely as well as by me.
    threads.shutdownNow();
    // Wait until all is done.
    boolean terminated = false;
    do {
      try {
        // Wait up to 1 second for termination.
        terminated = threads.awaitTermination(1, TimeUnit.SECONDS);
      } catch (InterruptedException ex) {
        // Ignore the interrupt! If I exit here we will probably leak.
      }
    } while (!terminated);
    log("! All done");
  }
}
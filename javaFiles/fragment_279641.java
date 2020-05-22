while(true) {
  double speedBeforeAdding = getCurrentSpeed();
  addThread();
  // Wait for speed to stabilise
  sleep(20 seconds);
  double speedAfterAdding = getCurrentSpeed();
  if(speedAfterAdding < speedBeforeAdding) {
    // Undo the addition of the new thread
    removeThread();
    // Wait for speed to stabilise
    sleep(20 seconds);

    if(getNumberOfThreads() > 1) {
      double speedBeforeRemoving = getCurrentSpeed();
      // Remove a thread because maybe there's too many
      removeThread();
      // Wait for speed to stabilise
      sleep(20 seconds);
      double speedAfterRemoving = getCurrentSpeed();
      if(speedAfterRemoving < speedBeforeRemoving) {
        // Add the thread back
        addThread();
        // Wait for speed to stabilise
        sleep(20 seconds);
      }
    }
  }
}
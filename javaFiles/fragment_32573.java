while (true) {
  int current = counter.get();
  if (counter.compareAndSet(current, current + 1)) {
    // Nothing else is trying to update "current" at the same time:
    // we updated it. Stop.
    break;
  }

  // Something else is trying to update at the same time.
  // Sleep for 3 seconds.
  Thread.sleep(3000);
}
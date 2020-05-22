/**
   * Schedules a timer to elapse in the future.
   * 
   * @param delayMillis how long to wait before the timer elapses, in
   *          milliseconds
   */
  public void schedule(int delayMillis) {
    if (delayMillis < 0) {
      throw new IllegalArgumentException("must be non-negative");
    }
    cancel();
    isRepeating = false;
    timerId = createTimeout(this, delayMillis);
    timers.add(this);  // <-- Adds itself to a static ArrayList<Timer> here
  }
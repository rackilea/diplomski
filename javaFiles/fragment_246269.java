public void run() {
  while (!Thread.getCurrentThread().isInterrupted()) {
    // Do your work here
    // Eventually check isInterrupted again before long running computations
  }
  // clean up and return
}
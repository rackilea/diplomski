public void run() {
  startTime = System.currentTimeMillis();  
  process = processBuilder.start();

  // spawn threads to consume process output streams
  // even if you're not going to read them

  while (running) {
    try {
      process.waitFor();
      running = false;
    } catch (InterruptedException e) {
      // you could stop a process by interrupting it's Job thread
      process.destroy();
    }
  }
  exitStatus = process.exitValue();
  endTime = System.currentTimeMillis();
  jobManager.onExit(this);
}
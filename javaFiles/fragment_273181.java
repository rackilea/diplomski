class WorkerThread {
  Semaphore sem;

  void checkForPause() throws InterruptedExec{
    synchronized(sem) { // make sure unpauseThread() cant release it
      sem.aquire(); // will block when pauseThread aquired one
      sem.release();
    }
  }

  void pauseThread() {
    sem.aquire();
  }

  void unpauseThread() {
    synchronized(sem) { sem.release(); } // only release after checkForPause()
  }

  work run() {
    while(true) { // do something in a loop
      checkForPause();
      // do actual work in small steps
    }
  }
}
public class SlaveAlgorithm {
  public void run() {
    try {
      threadBarrier.await();

      while (!stopConditionMet() && !isTerminated()) {
        performIteration()
      }
      done();
    }
    catch ...
  }

  /**
   * If not terminated notify observer the processing is done.
   */
  private void done() {
    if (!isTerminated()) {  
      terminationObserver.notifyDone(this)
    }
  }
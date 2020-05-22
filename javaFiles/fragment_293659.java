class ParentProcess{
  Map<int, CountDownLatch> finishSignals = new ConcurrentHashMap<int, CountDownLatch>();
  public void startProcess(){
    // Start child process
    // get its ID
    // and create a count down latch for it
    finishSignals.add(processId, new CountDownLatch(1));
  }
  public void shutDownProcess(processId){
    // Send an RMI request to process ID to shutdown
  }
  // RMI request sent from child process before stopping
  public void processFinishedNotification(processId){
    finishSignals[processId].countDown()
  }
  public void waitForChildsToFinish(){
    // This for loop will block until all child processes have sent a finish notification
    for(CountDownLatch childFinishSignal : finishSignals){
      childFinishSignal.await();
    }
  }
}
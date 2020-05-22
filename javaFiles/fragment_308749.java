public void run() {
  // Honor interrupts so that you can stop/kill the task
  while (!Thread.currentThread().interrupted()) {
    this.doSomeChunkOfWork();
  }    
}
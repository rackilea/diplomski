class YourTask implements Runnable {
  public void run() {
    Thread.currentThread().setName(getTaskId());
    //.. rest of the code for the task
  }
}
GlassFishWorkManagerTaskExecutor taskExecutor = new GlassFishWorkManagerTaskExecutor();
taskExecutor.setThreadPoolName("test_threadpool");
Runnable task = new Runnable() {
  public void run() {
    // do the task
  }
}
taskExecutor.execute(task);
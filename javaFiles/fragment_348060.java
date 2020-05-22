public static ExecutorService newScalingThreadPool(int min, int max, long keepAliveTime) {
   ScalingQueue queue = new ScalingQueue();
   ThreadPoolExecutor executor =
      new ScalingThreadPoolExecutor(min, max, keepAliveTime, TimeUnit.MILLISECONDS, queue);
   executor.setRejectedExecutionHandler(new ForceQueuePolicy());
   queue.setThreadPoolExecutor(executor);
   return executor;
}
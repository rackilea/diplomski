public WorkerThreadFactory implements ThreadFactory {
   private int counter = 0;

   public Thread newThread(Runnable r) {
     return new Thread(r, "Worker" + "-" + count++);
   }
}
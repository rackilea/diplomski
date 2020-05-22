public static void main(String... argv)
  throws Exception
{
  Path home = Paths.get(System.getProperty("user.home"));
  WatchService watcher = home.getFileSystem().newWatchService();
  home.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.OVERFLOW);
  Runnable task = new FileWatch(watcher);
  ExecutorService exec = Executors.newCachedThreadPool();
  exec.submit(task);
  Thread.sleep(3000);
  exec.shutdownNow();
  boolean terminated = exec.awaitTermination(1, TimeUnit.SECONDS);
  if (terminated)
    System.out.println("All tasks completed.");
  else
    System.out.println("Some tasks are still running.");
}
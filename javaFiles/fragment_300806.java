final class FileWatch implements Runnable {
  private final WatchService watcher;
  FileWatch(WatchService watcher) { this.watcher = watcher; }
  @Override
  public void run()
  {
    while (!Thread.currentThread().isInterrupted()) {
      WatchKey key;
      try {
        key = watcher.take();
      }
      catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
        break;
      }
      Watchable dir = key.watchable();
      System.out.println(dir);
      for (WatchEvent<?> evt : key.pollEvents()) {
        System.out.println("   " + evt.context());
      }
    }
  }
}
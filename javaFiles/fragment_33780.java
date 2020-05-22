WatchService watcher = FileSystems.getDefault().newWatchService();
Path dir = ...;
try {
    WatchKey key = dir.register(watcher, ENTRY_MODIFY);
} catch (IOException x) {
    System.err.println(x);
}
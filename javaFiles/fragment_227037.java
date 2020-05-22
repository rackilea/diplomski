WatchService watcher = FileSystems.getDefault().newWatchService();
Path dir = ...;
try {
    WatchKey key = dir.register(watcher,
                           StandardWatchEventKinds.ENTRY_CREATE,
                           StandardWatchEventKinds.ENTRY_DELETE,
                           StandardWatchEventKinds.ENTRY_MODIFY);
} catch (IOException x) {
    System.err.println(x);
}
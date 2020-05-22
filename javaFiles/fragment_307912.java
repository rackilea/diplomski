public void processEvents() {
    boolean finished = false;
    while (!finished) {
        // wait for key to be signaled
        WatchKey key;
        try {
            key = watcher.take();
        } catch (InterruptedException x) {
            return;
        }
        for (WatchEvent<?> event : key.pollEvents()) {
            WatchEvent.Kind<?> kind = event.kind();
            switch (kind.name()) {
                case "ENTRY_CREATE":
                    System.out.println("Creation has been detected in " + getDirName());
                    break;
                case "ENTRY_DELETE":
                    System.out.println("Deletion has been detected in " + getDirName());
                    break;
                case "ENTRY_MODIFY":
                    System.out.println("Modification has been detected in " + getDirName());
                    break;
                default:
                    continue;
            }
            if (!key.reset()) {
                finished = true;
            }
        }
    }
}
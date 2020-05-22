@SuppressWarnings("unchecked")
public class FileWorker extends SwingWorker<Void, PropertyChangeEvent> {

    public static final String FILE_DELETED = StandardWatchEventKinds.ENTRY_DELETE.name();
    public static final String FILE_CREATED = StandardWatchEventKinds.ENTRY_CREATE.name();
    public static final String FILE_MODIFIED = StandardWatchEventKinds.ENTRY_MODIFY.name();

    // final version will keep a map of keys/directories (just as in the tutorial example) 
    private Path directory;
    private WatchService watcher;

    public FileWorker(File file) throws IOException {
        directory = file.toPath();
        watcher = FileSystems.getDefault().newWatchService();
        directory.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
    }

    @Override
    protected Void doInBackground() throws Exception {
        for (;;) {
            // wait for key to be signalled
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return null;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                // TBD - provide example of how OVERFLOW event is handled
                if (kind == OVERFLOW) {
                    continue;
                }
                publish(createChangeEvent((WatchEvent<Path>) event, key));
            }

            // reset key return if directory no longer accessible
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
        return null;
    }

    /**
     * Creates and returns the change notification. This method is called from the 
     * worker thread while looping through the events as received from the Watchkey.
     * 
     * @param event
     * @param key
     */
    protected PropertyChangeEvent createChangeEvent(WatchEvent<Path> event, WatchKey key) {
        Path name = event.context();
        // real world will lookup the directory from the key/directory map
        Path child = directory.resolve(name);
        PropertyChangeEvent e = new PropertyChangeEvent(this, event.kind().name(), null, child.toFile());
        return e;
    }

    @Override
    protected void process(List<PropertyChangeEvent> chunks) {
        super.process(chunks);
        for (PropertyChangeEvent event : chunks) {
            getPropertyChangeSupport().firePropertyChange(event);
        }
    }
}
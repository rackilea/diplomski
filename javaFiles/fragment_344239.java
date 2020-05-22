public class myFileWatcherBean implements ActionListener {

    private Component someComponent;

    public myFileWatcherBean() {
        someComponent.addActionListener(this);
    }

    public void watchForChanges() {
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path dir = ...;

        try {
            WatchKey key = dir.register(watcher,
                       ENTRY_CREATE,
                       ENTRY_DELETE,
                       ENTRY_MODIFY);
            key = watcher.take();
            for (WatchEvent<?> event: key.pollEvents()) {
                  actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null) {
      //Nothing need go here, the actionPerformed method (with the
      //above arguments) will trigger the respective listener
});
            }
        } catch (IOException x) {
            System.err.println(x);
        }

    }
}
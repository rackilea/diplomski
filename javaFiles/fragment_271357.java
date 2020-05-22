public class ArchivingWorker extends SwingWorker<Void, Void> {
    JProgressBar progressBar = null;
    // Other members here...
    ...

    public ArchivingWorker(...) {
        // Any specific initialization here (in EDT)
        addPropertyChangeListener(new PropertyChangeListener() {
            @Override void propertyChange(PropertyChangeEvent e) {
                if (    "state".equals(e.getPropertyName())
                    &&  e.getNewValue() == StateValue.STARTED) {
                    // Background thread has just started, show a progress dialog here
                    progressBar = new JProgressBar();
                    ...
                }
                else if ("progress".equals(e.getPropertyName())) {
                    // Update progress bar here with e.getNewValue()
                    ...
                }
            }
        });
    }

    @Override protected Void doInBackground() {
        // Archiving process here and update progress from time to time
        setProgress(progress);

        return null;
    }

    @Override protected void done() {
        // Ensure that archiving process worked correctly (no exception)
        try {
            get();
        } catch (Exception e) {
            // Handle exception (user feedback or whatever)
        } finally {
            // Close progress dialog
            ...
        }
    }
}
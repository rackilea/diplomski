/**
 * Invoked when user clicks the button.
 */
public void actionPerformed(ActionEvent evt) {
    view.turnOnButton(false);
    progressBar.setIndeterminate(true);
    // NOTE: Instances of javax.swing.SwingWorker are not reusable, 
    // so we create new instances as needed
    worker = new Worker();
    worker.addPropertyChangeListener(new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if ("progress".equals(evt.getPropertyName())) {
                progressBar.setIndeterminate(false);
                progressBar.setValue(worker.getProgress());
            }
        }
    });
    worker.execute();
}
private class TaskListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SwingWorker task = (SwingWorker) evt.getSource();

        // here we can listen for changes to the worker's progress property
        // if we desire
        if ("progress".equals(evt.getPropertyName())) {
            int progress = task.getProgress();
            progressBar.setValue(progress);
        }

        // listen for the worker to be done
        if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
            // always need to know when the SW is done
            // so we can call get() and trap exceptions
            try {
                task.get();  // do something with the result returned?

                // !! here do things that you want done when the SwingWorker has completed ***

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
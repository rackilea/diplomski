public void actionPerformed(ActionEvent e) {
    if ("refresh".equals(e.getActionCommand())) {
        label.setText("Loading...");

        // create a SwingWorker object
        final SwingWorker<Void, Void> worker = new Swingworker<Void, Void>() {

            // long running code would go in doInBackground
            public Void doInBackground() throws Exception {
                Main.searcher(...);
                return null;
            }
        }

        // add a listener to worker to be notified when it is done
        worker.addPropertyChangeListener(PropertyChangeListener listener) {
            public void propertyChanged(PropertyChangeEvent pcEvt) {

                // if the worker is done...
                if (pcEvt.getNewValue() == SwingWorker.StateValue.DONE) {
                    label.setText("");

                    // you will probably want to call get() on your worker here
                    // and catch any exceptions that may have occurred.
                }
            }
        }

        // it may seem counter-intuitive, but you need to start the worker with 
        // execute() *after* setting all the above code up.
        worker.execute();
    }
}
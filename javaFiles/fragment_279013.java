uploadNotamButton.addActionListener((ActionEvent e) -> {
    // if(e.getSource()==uploadNotamButton)
    uploadNotamButton.setText("STANDBY");
    progressLabel.setText("Process Has Begun, standby...");
    progressLabel.setVisible(true);

    // create worker to do background work
    SwingWorker<Void, Void> worker = new SwingWorker<>() {
        @Override
        protected Void doInBackground() throws Exception {
            // this is all done within a background thread
            uploadNotams();  // don't make any Swing calls from within this method
            return null;
        }
    };

    // get notified when the worker is done, and respond to it
    worker.addPropertyChangeListener(new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getNewValue == SwingWorker.StateValue.DONE) {
                uploadNotamButton.setText("COMPLETE");

                // the code below needs to be surrounded by a try/catch block
                // and you'll need to handle any exceptions that might be caught
                ((SwingWorker) evt.getSource()).get();
            }
        }
    });
    worker.execute();  // run the worker
});
class Action1 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        openFile();
        // load.Close();  // get rid of this
    }
}

// .......

private void openFile() {

    // ....

    load.Show(true);  // load dialog on event thread

    new SwingWorker<Void, Void>() {
        protected Void doInBackground() throws Exception {
            createDoc(path);  // call this from background thread
            return null;
        };

        protected void done() {
            load.Close();  // only call this once createDoc has completed
            // probably should call get() in here to catch all exceptions
        };
    }.execute();
}
void start() {
    // Check to see if the worker is already running...
    if (worker == null || worker.isDone() || worker.isCancelled()) {
        worker = new SwingWorker<String, Void>() {

        @Override
        protected String doInBackground() throws Exception {
            //...
        }

        protected void done() {
            worker = null;
            //...
        }

    };
    //...
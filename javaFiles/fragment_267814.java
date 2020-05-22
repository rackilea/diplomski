SwingWorker<Server , Object> worker = new SwingWorker<Server , Object>() {
    @Override
    protected ServerdoInBackground() throws Exception {
        Server server = new Server();
        //...
        // Use publish(...) to send information
        // back the EDT via the process method...
        return server;
    }

    @Override
    protected void done() {
        try {
            Server server = get();
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void process(List<Object> chunks) {
        // You can safly update the UI from here, maybe
        // with some messages??
    }

};
worker.execute();
public final void method(final Runnable callback) {

    someObject.before();

    SwingWorker<Void, Void> worker1 = new SwingWorker<Void, Void>() {

        protected Void doInBackground() throws Exception {
            methodExt();
            return null;
        }

        protected void done() {
            someObject.after();
            if(callback != null) callback.run();
        }
    };

    worker1.execute();
}
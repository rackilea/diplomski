public void open() throws InterruptedException {
    Display display = Display.getDefault();
    createContents();
    shell.open();

    Thread updateThread = new Thread() {
        public void run() {
            while (true) {
                final ArrayList<Request> pendingRequests = getPendingRequests();
                Display.getDefault().syncExec(new Runnable() {

                    @Override
                    public void run() {
                        populateList(pendingRequests);
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    // background thread
    updateThread.setDaemon(true);
    updateThread.start();

    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
}
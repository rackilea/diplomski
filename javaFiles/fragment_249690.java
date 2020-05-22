class PacketCaptureWorker implements Runnable {
    private volatile boolean cancelled = false;
    public void cancel() {
        cancelled = true;
    }
    public void run() {
        while (!cancelled) {
            //do work
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Use the result of your computation on the EDT
            }
        });
    }
}

new Thread(new PacketCaptureWorker()).start();
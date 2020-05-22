@Override
protected Void doInBackground() throws Exception {
    // System.out.println("Background");
    while(!isCancelled()) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Background interrupted");
        }
        System.out.println("Background running");
    }
    return null;
}
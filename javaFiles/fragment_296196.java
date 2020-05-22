SwingWorker<Boolean, Void>worker =  new SwingWorker<Boolean, String>() {

    protected Boolean doInBackground() throws Exception {
        publish(fileName);
        ZipUtility zu = new ZipUtility(fileName));
        return zu.extract(fileName);
    }
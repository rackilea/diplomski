new SwingWorker<Void,Void>() {
    @Override
    protected Void doInBackground() throws Exception {
        Thread.sleep(500);
        return null;
    }
    @Override
    protected void done() {
        cell2.setIcon(image2);
    }
}.execute();
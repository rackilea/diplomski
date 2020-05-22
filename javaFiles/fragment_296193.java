public static class Worker extends SwingWorker {

    private int sequence;

    public Worker(int sequence) {
        this.sequence = sequence;
    }

    @Override
    protected Object doInBackground() throws Exception {
        System.out.println(sequence + "...");
        Thread.sleep(500);
        return null;
    }

}
// mock up of SwingWorker for long-running action
class LongRunningSwProcess extends SwingWorker<Void, Integer> {
    public static final String COUNT = "count";
    private static final int MIN_TIME_OUT = 5;
    private static final int MAX_TIME_OUT = 10;
    private int count = 0;

    @Override
    protected Void doInBackground() throws Exception {
        // all this mock up does is increment a count field 
        // every second until timeOut reached
        int timeOut = MIN_TIME_OUT + (int) (Math.random() * (MAX_TIME_OUT - MIN_TIME_OUT));
        for (int i = 0; i < timeOut; i++) {
            setCount(i);
            TimeUnit.SECONDS.sleep(1);
        }
        return null;
    }

    // make count a "bounded" property -- one that will notify listeners if changed
    public void setCount(int count) {
        int oldValue = this.count;
        int newValue = count;
        this.count = newValue;
        firePropertyChange(COUNT, oldValue, newValue);
    }

    public int getCount() {
        return count;
    }
}
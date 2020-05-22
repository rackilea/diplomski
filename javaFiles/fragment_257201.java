public class DataLoader {
    private volatile Stuff data;
    private final CountDownLatch latch = new CountDownLatch(1);
    // start the thread, called early in main()
    public void init() {
        // you pass in this so it can call setData
        DataRetrievalThread t = new DataRetrievalThread(this);
        t.start();
    }
    // called from the DataRetrievalThread
    public void setData(Stuff data) {
        this.data = data;
        latch.countDown();
    }
    public Stuff getData() {
        if (data == null) {
            latch.await();
        }
        return data;
    }
}
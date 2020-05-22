public WaitableFuture<T>
    extends Future<T>
{
    private CountDownLatch countDownLatch;

    WaitableFuture(CountDownLatch countDownLatch)
    {
        super();

        this.countDownLatch = countDownLatch;
    }

    void doTask()
    {
        super.doTask();

        this.countDownLatch.countDown();
    }
}
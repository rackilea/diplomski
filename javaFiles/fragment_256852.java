public class BlockingGameObserver extends GameInstanceObserver {
    private CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void update() {
        latch.countDown();
    }

    public void waitUntilUpdateIsCalled() throws InterruptedException {
        latch.await();
    }
}
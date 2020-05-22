final CountDownLatch start = new CountDownLatch(2);
final CountDownLatch end = new CountDownLatch(2);

Runnable r1 = new Runnable() {
    @Override
    public void run() {
        try {
            start.countDown();
            start.await();
            System.out.println("In 1");
            end.countDown();
            end.await();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt(); //restore interruption status
        }
    }
};
Runnable r2 = new Runnable() {
    @Override
    public void run() {
        try {
            start.countDown();
            start.await();
            System.out.println("In 2");
            end.countDown();
            end.await();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt(); //restore interruption status
        }
    }
};
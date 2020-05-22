public static void main(String[] args) {

    CountDownLatch cdl = new CountDownLatch(1);
    Timer timer = new Timer();
    timer.schedule(new MyTimerTask(cdl), 3000);

    try {
        cdl.await();
    } catch (InterruptedException ex) {
    }

    //execute this code after timer finished
    System.out.println("finish");
}

private static class MyTimerTask extends TimerTask {

    private CountDownLatch latch;

    public MyTimerTask(CountDownLatch lock) {
        this.latch = lock;
    }

    @Override
    public void run() {
        System.out.println("inside timer");
        latch.countDown();
    }

}
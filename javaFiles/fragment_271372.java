class Resource {
    private final Object lock = new Object();
    String commonResource = new String();

    public void consume() throws InterruptedException {
        System.out.println("In consume. Outside Sync block: " + Thread.currentThread().getName());
        synchronized (lock) {
            System.out.println("In consume. Inside Sync block" + Thread.currentThread().getName());
            lock.wait();
            System.out.println(commonResource);
        }
    }

    public void produce() throws InterruptedException {
        System.out.println("In Produce. Outside Sync block: " + Thread.currentThread().getName());
        // So that consumer executes first
        Thread.sleep(1000L);
        synchronized (lock) {
            System.out.println("In produce. Inside sync block: " + Thread.currentThread().getName());
            commonResource = "I am not empty now";
            System.out.println("Done production. I am now freeing up the resource");
            lock.notifyAll();
        }
    }
}
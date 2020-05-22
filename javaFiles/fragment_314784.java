static class Worker implements Runnable {

    final Semaphore semaphore;

    public Worker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            try {
                //do stuff
            } finally {
                semaphore.release();
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}

public static void main(String[] args) {

    final int numThreads = 10;
    final ExecutorService executorService = Executors.newFixedThreadPool(10);
    final Semaphore semaphore;
    boolean myflag = true;
    if (myflag) {
        semaphore = new Semaphore(1);
    } else {
        semaphore = new Semaphore(numThreads);
    }
    final Worker worker = new Worker(semaphore);
    executorService.submit(worker);
}
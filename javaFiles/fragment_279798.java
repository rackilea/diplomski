BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(1);
ExecutorService ex = new ThreadPoolExecutor(2, 2, 60L, TimeUnit.MILLISECONDS, queue);
Runnable runnable = new Runnable() {
    @Override
    public void run() {
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
};
try {
    ex.submit(runnable); // 1st thread
    ex.submit(runnable); // 2nd thread
    ex.submit(runnable); // 1st queued
    ex.submit(runnable); // rejected
} catch (RejectedExecutionException e) {
    System.out.println("rejected");
}
private static final int NB_THREADS = 3;

public static void main(String[] args) {

    ExecutorService executorService = Executors.newFixedThreadPool(NB_THREADS);

    for (int i = 0; i < NB_THREADS; i++) {
        final int nb = i + 1;
        Runnable task = new Runnable() {
            public void run() {
                System.out.println("Task " + nb);
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("Task " + nb + " terminated");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Error during thread await " + e); // Logging framework should be here
                }
            }
        };

        executorService.submit(task);
    }


    executorService.shutdown();
    try {
        executorService.awaitTermination(1, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Error during thread await " + e);
    }
}
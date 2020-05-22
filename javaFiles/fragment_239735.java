public static void main(String[] args) {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1, 3, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(3));
    try {
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        int numJobs = 50;
        for (int i = 1; i <= numJobs; i++) {
            try {
                executor.submit(new WorkerThread(i));
                System.out.println("Added#" + (i));
            } catch (RejectedExecutionException e) {
                e.printStackTrace();
            }
        }
    } finally {
        executor.shutdown();
    }
}
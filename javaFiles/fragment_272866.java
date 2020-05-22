public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        for (int i = 0; i < 1000; i++) {
            final int finalI = i;
            main.submitTask(new Callable<Long>() {
                @Override
                public Long call() throws Exception {
                    long millis = (long) (Math.pow(2000, Math.random()));
                    Thread.sleep(millis);
                    return millis;
                }
            }, new ResultHandler<Long>() {
                @Override
                public void onFuture(Future<Long> future) throws ExecutionException, InterruptedException {
                    System.out.println(new Date() + ": " + finalI + " - Slept for " + future.get() + " millis");
                }
            });
        }
        main.shutdown();
    }


    public interface ResultHandler<T> {
        void onFuture(Future<T> future) throws Exception;
    }

    private final ExecutorService pool = Executors.newFixedThreadPool(10);
    private final ExecutorService result = Executors.newSingleThreadExecutor();

    public synchronized <T> void submitTask(Callable<T> callable, final ResultHandler<T> resultHandler) {
        final Future<T> future = pool.submit(callable);
        result.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    resultHandler.onFuture(future);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void shutdown() {
        pool.shutdown();
        result.shutdown();
    }
}
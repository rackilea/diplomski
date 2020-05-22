@Component
public class ExecutorWrapper implements DisposableBean {

    private final ThreadPoolExecutor threadPoolExecutor;

    public ExecutorWrapper() {
        threadPoolExecutor = new ThreadPoolExecutor(10, 100, 60L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1000), new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public <T> Future<T> submit(Callable<T> task) {
        return threadPoolExecutor.submit(task);
    }

    public void submit(Runnable runnable) {
        threadPoolExecutor.submit(runnable);
    }

    @Override
    public void destroy() throws Exception {
        threadPoolExecutor.shutdown();
        boolean terminated = threadPoolExecutor.awaitTermination(1, TimeUnit.MINUTES);
        if (!terminated) {
            List<Runnable> runnables = threadPoolExecutor.shutdownNow();
            // log the runnables that were not executed
        }
    }
}
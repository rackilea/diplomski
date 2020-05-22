import java.util.concurrent.*;

...

private ExecutorService exec = Executors.newSingleThreadExecutor();
public ResponseContext delayBy20Seconds(RequestContext context) {
    Callable<ResponseContext> task = new Callable<ResponseContext>() {
        @Override
        public ResponseContext call() throws Exception {
            Thread.sleep(20000);
            return new ResponseContext().contentType(MediaType.APPLICATION_JSON_TYPE);
        }
    };
    List<Callable<ResponseContext>> tasks = new ArrayList<>();
    tasks.add(task);
    List<Future<ResponseContext>> done = exec.invokeAll(tasks, 15, TimeUnit.SECONDS);
    Future<ResponseContext> task1 = done.get(0);
    if (task1.isCancelled()) {
        return some Error Response;
    }
    return task1.get();
}
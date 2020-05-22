ExecutorService executorService = acquireExecutorService();

final int readTimeout = 1000;
final int connectionTimeout = 2000;
final File target = new File("target");
final URL source = new URL("source");

Future<?> task = executorService.submit(new Runnable() {
    @Override
    public void run() {
        try {
            FileUtils.copyURLToFile(source, target, connectionTimeout, readTimeout);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
});
try {
    task.get(30, TimeUnit.SECONDS);
} catch (InterruptedException | ExecutionException e) {
    //handle exceptions
} catch (TimeoutException e) {
    task.cancel(true); //interrupt task
}
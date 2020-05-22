/**
 * Shutdown the given executor service and wait for tasks to finish.
 * If tasks do not finish within the given time-out, the executor service is forcibly closed
 * (running tasks are interrupted) and tasks that never commenced execution are returned.  
 * @param es the executor service to shutdown
 * @param timeoutSeconds the maximum time in seconds to wait.
 * @return null on normal shutdown, else a list of tasks that never commenced execution
 */
public static List<Runnable> shutdown(ExecutorService es, int timeoutSeconds) {

    es.shutdown();
    if (timeoutSeconds > 0) {
        try {
            es.awaitTermination(timeoutSeconds, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.warn("Waiting for executor service tasks completion interrupted.", e);
        }
    }
    return (es.isTerminated() ? null : es.shutdownNow());
}
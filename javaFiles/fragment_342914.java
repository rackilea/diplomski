public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
    V content = null;
    try {
        if (innerFuture != null) {
            content = innerFuture.get(timeout, unit);
        }
    } catch (TimeoutException t) {
        if (!contentProcessed.get() && timeout != -1 && ((System.currentTimeMillis() - touch.get()) <= responseTimeoutInMs)) {
            return get(timeout, unit);
        }

        if (exception.get() == null) {
            timedOut.set(true);
            throw new ExecutionException(new TimeoutException(String.format("No response received after %s", responseTimeoutInMs)));
        }
    } catch (CancellationException ce) {
    }

    if (exception.get() != null) {
        throw new ExecutionException(exception.get());
    }
    return content;
}
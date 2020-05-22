public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
    throws InterruptedException {
    if (tasks == null)
        throw new NullPointerException();
    List<Future<T>> futures = new ArrayList<Future<T>>(tasks.size());
    boolean done = false;
    try {
        for (Callable<T> t : tasks) {
            RunnableFuture<T> f = newTaskFor(t);
            futures.add(f);
            execute(f);
        }
        for (Future<T> f : futures) {
            if (!f.isDone()) {
                try {
                    f.get(); //If interrupted, this is where the InterruptedException will be thrown from
                } catch (CancellationException ignore) {
                } catch (ExecutionException ignore) {
                }
            }
        }
        done = true;
        return futures;
    } finally {
        if (!done)
            for (Future<T> f : futures)
                f.cancel(true); //Specifying "true" is what allows an interrupt to be sent to the ExecutorService's worker threads
    }
}
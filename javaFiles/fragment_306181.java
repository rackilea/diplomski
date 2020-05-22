ExecutorService execService = // ... e.g. new ThreadPoolExecutor(...)

<T> T compute(
    Callable<? extends T> good,
    Callable<? extends T> better,
    Callable<? extends T> best) {

    RelatedCallables calls = new RelatedCallables(); // new for each batch
    Future<T> bestResult = execService.submit(calls.wrap(best)); // first wrapped is primary
    Future<T> betterResult = execService.submit(calls.wrap(better));
    Future<T> goodResult = execService.submit(calls.wrap(good));

    try {
        if (!calls.awaitPrimary(5, TimeUnit.SECONDS)) {
            calls.awaitAny(); // waits indefinitely, unless THIS thread interrupted
        }
        // reaching here means at least one of them has a result
        if (bestResult.isDone()) return bestResult.get();
        if (betterResult.isDone()) return betterResult.get();
        return goodResult.get();
    }
    catch (ExecutionException failedExecution) {
        // TODO: handling this is left as an exercise for the reader
        return null;
    }
    catch (InterruptedException interrupted) {
        // TODO: handling this is left as an exercise for the reader
        return null;
    }
    finally {
        boolean sendInterrupt = true; // or false, depending on your needs
        goodResult.cancel(sendInterrupt);
        betterResult.cancel(sendInterrupt);
        bestResult.cancel(sendInterrupt);
    }
}
final FutureTask<Object> lazyLoadedData = new FutureTask<>(() -> expensiveIO());

...

if (!lazyLoadedData.isDone()) {
    synchronized(lazyLoadedData) {
        if (!lazyLoadedData.isDone()) {
            // run() does the computation and sets the data
            // essentially, lazyLoadedData.set(expensiveIO())
            lazyLoadedData.run();
        }
    }
}
// Data is available
lazyLoadedData.get();
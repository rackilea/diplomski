try {
    // do some work which might throw an exception
} catch (Throwable t) {
    // do something with t.
    Thread.currentThread().stop(t);
}
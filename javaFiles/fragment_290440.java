public Overflow() {
    try {
        new Overflow();
    }
    catch(StackOverflowError e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        // if the stack trace length is at  the limit , throw a new StackOverflowError, which will have one entry less in it.
        if (stackTrace.length == 1024) {
            throw new StackOverflowError();
        }
        throw e;  // if it is small enough, just rethrow it.
    }
}
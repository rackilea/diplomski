public static <R> R retry(Callable<R> action) {
    // Retry logic
    while(/* retry condition */) {
        action.call();
    }
}
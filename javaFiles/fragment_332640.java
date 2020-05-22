static CompletableFuture<Void> myMethod(Runnable runnable) {
    Map<String, String> previous = MDC.getCopyOfContextMap();
    return CompletableFuture.runAsync(() -> {
        MDC.setContextMap(previous);
        try {
            runnable.run();
        } finally {
            MDC.clear();
        }
    });
}
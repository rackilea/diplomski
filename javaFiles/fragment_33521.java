RxJavaPlugins.setErrorHandler(e -> {
    // ..
    if (e instanceof InterruptedException) {
        // fine, some blocking code was interrupted by a dispose call
        return;
    }
    // ...
    Log.warning("Undeliverable exception received, not sure what to do", e);
});
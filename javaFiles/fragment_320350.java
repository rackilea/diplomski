static {
    try {
        Shutdown.add(1 /* shutdown hook invocation order */,
            false /* not registered if shutdown in progress */,
            new Runnable() {
                public void run() {
                    runHooks(); // (!!)  your hooks
                }
            }
        );
        hooks = new IdentityHashMap<>();
    } catch (IllegalStateException e) {
        // application shutdown hooks cannot be added if
        // shutdown is in progress.
        hooks = null;
    }
}
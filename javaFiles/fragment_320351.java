static void runHooks() { // In ApplicationShutdownHooks
    Collection<Thread> threads;
    synchronized(ApplicationShutdownHooks.class) {
        threads = hooks.keySet();
        hooks = null;
    }

    for (Thread hook : threads) { // (!!) your hooks
        hook.start();
    }
    for (Thread hook : threads) {
        try {
            hook.join();
        } catch (InterruptedException x) { }
    }
}
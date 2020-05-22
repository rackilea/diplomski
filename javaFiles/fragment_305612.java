static void runHooks() {
    ...
    for (Thread hook : threads) {
        hook.start();
    }
    for (Thread hook : threads) {
        hook.join();
    }
}
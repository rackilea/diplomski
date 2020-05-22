// This private class is used as a shutdown hook.
// It does a "reset" to close all open handlers.
private class Cleaner extends Thread {

    private Cleaner() {
        /* Set context class loader to null in order to avoid
         * keeping a strong reference to an application classloader.
         */
        this.setContextClassLoader(null);
    }

    @Override
    public void run() {
        // This is to ensure the LogManager.<clinit> is completed
        // before synchronized block. Otherwise deadlocks are possible.
        LogManager mgr = manager;

        // If the global handlers haven't been initialized yet, we
        // don't want to initialize them just so we can close them!
        synchronized (LogManager.this) {
            // Note that death is imminent.
            deathImminent = true;
            initializedGlobalHandlers = true;
        }

        // Do a reset to close all active handlers.
        reset();
    }
}
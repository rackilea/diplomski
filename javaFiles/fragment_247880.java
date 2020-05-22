// This private class is used as a shutdown hook.
// It does a "reset" to close all open handlers.
private class Cleaner extends Thread {

    private Cleaner() {
        /* Set context class loader to null in order to avoid
         * keeping a strong reference to an application classloader.
         */
        this.setContextClassLoader(null);
    }

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


/**
 * Protected constructor.  This is protected so that container applications
 * (such as J2EE containers) can subclass the object.  It is non-public as
 * it is intended that there only be one LogManager object, whose value is
 * retrieved by calling Logmanager.getLogManager.
 */
protected LogManager() {
    // Add a shutdown hook to close the global handlers.
    try {
        Runtime.getRuntime().addShutdownHook(new Cleaner());
    } catch (IllegalStateException e) {
        // If the VM is already shutting down,
        // We do not need to register shutdownHook.
    }
}
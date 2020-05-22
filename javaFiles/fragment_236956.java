/* Invoked by Runtime.exit, which does all the security checks.
 * Also invoked by handlers for system-provided termination events,
 * which should pass a nonzero status code.
 */
static void exit(int status) {
boolean runMoreFinalizers = false;
synchronized (lock) {
    if (status != 0) runFinalizersOnExit = false;
    switch (state) {
    case RUNNING:   /* Initiate shutdown */
    state = HOOKS;
    break;
    case HOOKS:     /* Stall and halt */
    break;
    case FINALIZERS:
    if (status != 0) {
        /* Halt immediately on nonzero status */
        halt(status);
    } else {
        /* Compatibility with old behavior:
         * Run more finalizers and then halt
         */
        runMoreFinalizers = runFinalizersOnExit;
    }
    break;
    }
}
if (runMoreFinalizers) {
    runAllFinalizers();
    halt(status);
}
synchronized (Shutdown.class) {
    /* Synchronize on the class object, causing any other thread
         * that attempts to initiate shutdown to stall indefinitely
     */
    sequence();
    halt(status);
}
}
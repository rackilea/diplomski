/**
 * Use this to log a message when a thread exits due to an uncaught
 * exception.  The framework catches these for the main threads, so
 * this should only matter for threads created by applications.
 */
private static class UncaughtHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        try {
            // Don't re-enter -- avoid infinite loops if crash-reporting crashes.
            if (mCrashing) return;
            mCrashing = true;
            if (mApplicationObject == null) {
                Slog.e(TAG, "*** FATAL EXCEPTION IN SYSTEM PROCESS: " + t.getName(), e);
            } else {
                Slog.e(TAG, "FATAL EXCEPTION: " + t.getName(), e);
            }
            // Bring up crash dialog, wait for it to be dismissed
            ActivityManagerNative.getDefault().handleApplicationCrash(
                    mApplicationObject, new ApplicationErrorReport.CrashInfo(e));
        } catch (Throwable t2) {
            try {
                Slog.e(TAG, "Error reporting crash", t2);
            } catch (Throwable t3) {
                // Even Slog.e() fails!  Oh well.
            }
        } finally {
            // Try everything to make sure this process goes away.
            Process.killProcess(Process.myPid());
            System.exit(10);
        }
    }
}
private static final void commonInit() {
    if (DEBUG) Slog.d(TAG, "Entered RuntimeInit!");
    /* set default handler; this applies to all threads in the VM */
    Thread.setDefaultUncaughtExceptionHandler(new UncaughtHandler());
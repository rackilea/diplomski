public static long getMonitorOwner(Object obj) {
    if (Thread.holdsLock(obj)) return Thread.currentThread().getId();
    for (java.lang.management.ThreadInfo ti :
            java.lang.management.ManagementFactory.getThreadMXBean()
            .dumpAllThreads(true, false)) {
        for (java.lang.management.MonitorInfo mi : ti.getLockedMonitors()) {
            if (mi.getIdentityHashCode() == System.identityHashCode(obj)) {
                return ti.getThreadId();
            }
        }
    }
    return 0;
}
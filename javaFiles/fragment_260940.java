// Note: adding 1 here to give some breathing room during
    // orientation changes.  (shouldn't be necessary, though?)
    limit = newExpected + 1;

    ...

    // Quick check.
    int actual = InstanceTracker.getInstanceCount(klass);
    if (actual <= limit) {
        return;
    }

    // Do a GC and explicit count to double-check.
    // This is the work that we are trying to avoid by tracking the object instances
    // explicity.  Running an explicit GC can be expensive (80ms) and so can walking
    // the heap to count instance (30ms).  This extra work can make the system feel
    // noticeably less responsive during orientation changes when activities are
    // being restarted.  Granted, it is only a problem when StrictMode is enabled
    // but it is annoying.
    Runtime.getRuntime().gc();

    long instances = VMDebug.countInstancesOfClass(klass, false);
    if (instances > limit) {
        Throwable tr = new InstanceCountViolation(klass, instances, limit);
        onVmPolicyViolation(tr.getMessage(), tr);
    }
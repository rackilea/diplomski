private static boolean shouldBroadcastSafe(
        Location loc, Location lastLoc, UpdateRecord record, long now) {
    // Always broadcast the first update
    if (lastLoc == null) {
        return true;
    }

    // Check whether sufficient time has passed
    long minTime = record.mRequest.getFastestInterval();
    long delta = (loc.getElapsedRealtimeNanos() - lastLoc.getElapsedRealtimeNanos())
            / NANOS_PER_MILLI;
    if (delta < minTime - MAX_PROVIDER_SCHEDULING_JITTER_MS) {
        return false;
    }

    // Check whether sufficient distance has been traveled
    double minDistance = record.mRequest.getSmallestDisplacement();
    if (minDistance > 0.0) {
        if (loc.distanceTo(lastLoc) <= minDistance) {
            return false;
        }
    }
...
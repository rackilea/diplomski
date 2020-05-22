boolean innerCancel(boolean mayInterruptIfRunning) {
    for (;;) {
        int s = getState();
        if (ranOrCancelled(s))
            return false;
        if (compareAndSetState(s, CANCELLED)) // <-----
            break;
    }
    if (mayInterruptIfRunning) {
        Thread r = runner;
        if (r != null)
            r.interrupt(); // <-----
    }
    releaseShared(0);
    done(); // <-----
    return true;
}
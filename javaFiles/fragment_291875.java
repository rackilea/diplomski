protected synchronized IThread getNextSuspendedThread() {
    if (!fThreadQueue.isEmpty()) {
        return (IThread) fThreadQueue.iterator().next();
    }
    return null;
}
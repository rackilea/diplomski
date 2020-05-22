/** Properly dispose of native memory when this object is GC'd. */
protected void finalize() {
    dispose();
}

/** Free the native memory and set peer to zero */
protected synchronized void dispose() {
    free(peer);
    peer = 0;
    allocatedMemory.remove(this);
}
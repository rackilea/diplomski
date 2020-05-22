public void maybeAccessConcurrently(Program x) {
    if(halts(x)) {
        accessConcurrentObject();
    } else {
        // don't.
    }
}
synchronized void syncMethod() {
    // do something
}

void syncManually() {
    synchronized (this) {
        // do something
    }
}
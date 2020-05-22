myMethod (Bool useLock) {
    if (useLock) {
        synchronized (this) {
           criticalSection();
        }
    } else {
        criticalSection();
    }
}

criticalSection() {
   //do more stuff....
}
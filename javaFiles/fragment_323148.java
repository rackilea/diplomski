public testMyMethod () {
    byte[] buffer = new int[1024];
    int numRead = -1;
    while ((numRead = readInput(buffer)) != -1) {
        out.write(buffer);
    }
}

//first method
int readInput(byte[] buffer) {
    int readLen = -1;
    synchronized(in) {
        in.read(buffer);
    }
    return readLen;
}

//second method, more performant about 3 times, just the synchronization parts
private static final ReentrantLock inputLock = new ReentrantLock();

int readInput(byte[] buffer) {
    int readLen = -1;
    inputLock.lock();
    try {
        readLen = in.read(buffer);
    } finally {
        inputLock.unlock();
    }
    return readLen;
}
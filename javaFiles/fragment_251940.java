// in a client connection thread
lock.lock();
try {
    // use connection to server B
} finally {
    lock.unlock();
}
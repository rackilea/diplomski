volatile boolean canGoOn = false;
final Object condition = new Object();

// in main:
B;
synchronized (condition) {
    canGoOn = true;
    condition.notify();
}

// in thread:
synchronized (condition) {
    while (!canGoOn) {
        condition.wait();
    }
}
E;
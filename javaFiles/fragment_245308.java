public int incCounter() {
    synchronized (this) {
        counter = counter + 1;
        return counter;
    }
}
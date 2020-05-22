public void increment() {
    int localCount;
    synchronized (lock) {
        count = count + 1;
        localCount = count; // volatile load
    }
    System.out.print(" " + localCount);
}
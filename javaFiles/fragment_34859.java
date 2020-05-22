public void moveSynchronized(int from, int to, int amount) {
    if(from == to || from < 0 || to < 0 || from > cells.length || to.cells.length)
        throw new IllegalArgumentException("Bad values ! " + from + ", " + to);

    // Lock1 is always smaller and locked first
    int lock1 = from < to ? from : to;
    int lock2 = from < to ? to : from;

    synchronized(locks[lock1]) {
        synchronized (locks[lock2]) {
            if(cells[from] >= amount) {
                cells[from] = cells[from] - amount;
                cells[to] = cells[to] + amount;
            }
        }
    }
}
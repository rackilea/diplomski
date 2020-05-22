private boolean locked = false;

public void enqueue(int number) {
    synchronized (this) {
        if (locked) {
            return;
        }
        locked = true;
    }

    try {
        // Synchronized goodness goes here.
    } finally {
        synchronized (this) {
            locked = false;
        }
    }
}
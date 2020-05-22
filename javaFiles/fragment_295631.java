public static int number = 0;
public static final Object lock = new Object();

public void increment() {
    synchronized (lock) {
        number++;
    }
}

public int getNumber() {
    synchronized (lock) {
        return number;
    }
}
package mypackage;

class MyRunnable implements Runnable {
    private final String message;

    MyRunnable(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(this.message);
    }
}

public class Surprises {
    public static Runnable getSurprise() {
        return new MyRunnable("boo!");
    }
}
public class Unsafe {
    public final int foo = 42;
    public Unsafe(Unsafe[] leak) {
        leak[0] = this;   // Unsafe publication
        // Make the "window of vulnerability" large
        for (long l = 0; l < /* very large */ ; l++) {
            ...
        }
    }
}

public class Main {
    public static void main(String[] args) {
        final Unsafe[] leak = new Unsafe[1];
        new Thread(new Runnable() {
            public void run() {
                Thread.yield();   // (or sleep for a bit)
                new Unsafe(leak);
            }
        }).start();

        while (true) {
            if (leak[0] != null) {
                if (leak[0].foo == 42) {
                    System.err.println("OK");
                } else {
                    System.err.println("OUCH!");
                }
                System.exit(0);
            }
        }
    }
}
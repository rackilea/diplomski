public interface NotRunnable {
    void foo();
}

Runnable thing1 = Main::doStuff; // After making doStuff static
NotRunnable thing2 = Main::doStuff;
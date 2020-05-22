public class Sample {
    Map mMyMap = new ConcurrentHashMap();

    void foo() {
        // Access from here
    }

    class Thread {
        // And from here
    }
}
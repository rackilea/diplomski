public static void main(String... args) throws Exception {
    ExecutorService s = Executors.newCachedThreadPool();
    Future<MyObject> f = s.submit(() -> new MyObject(42));
    assert (f.get().x == 42); // guaranteed!
    s.shutdown();
}

public class MyObject {
    int x;
    public MyObject(int x) { this.x = x; }
}
public static void main(String... args) throws Exception {
    ExecutorService s = Executors.newCachedThreadPool();
    MyObject o = new MyObject(42);
    Future<?> f = s.submit(() -> o.x++); // new --hb--> submit
    f.get(); // get -->hb--> read o.x
    assert (o.x == 43); // guaranteed
    s.shutdown();
}

public static class MyObject {
    int x;
    public MyObject(int x) { this.x = x; }
}
public void test() {
    Runnable r = () -> System.out.println("Hello!");
    doTwice(r);
    // you can one-liner it too of course:
    doTwice(() -> System.out.println("World!"));
}

public void doTwice(Runnable r) {
    r.run();
    r.run();
}
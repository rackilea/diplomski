class Foobar {
    private final Object lock = new Object();

    ...

    public SomeType someOperation(...) {
        ...
        synchronized(lock) {
             doSomethingThatNeedsProtection();
        }
        ...
    }
}
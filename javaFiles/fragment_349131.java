class MyClass {
    private final Object myLock = new Object();

    SomeType someMethod(...) {
        synchronized(myLock) {
            ....
         }
    }
}
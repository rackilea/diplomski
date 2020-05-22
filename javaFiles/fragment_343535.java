private static volatile Foo foo; 
private static volatile Bar bar;     
private static final Object fooLock = new Object();
private static final Object barLock = new Object();

private static void initBar() {
    bar = SomeOtherClass.getBarVal();
}

private static void initFoo() {
    foo = SomeOtherClass.getFooVal();
}

public static Foo getFoo() {
    if (foo == null) {
        synchronized (fooLock) {
            if (foo == null) {
                initFoo();
            }
        }
    }
    return foo;
}

public static Foo getBar() {
    if (bar == null) {
        synchronized (barLock) {
            if (bar == null) {
                initBar();
            }
        }
    }
    return foo;
}
public class B extends A<B> {
    // empty
}

public class C extends A<B> {
    // empty
}

public class AnotherClass {
    public void someMethod() {
        A<B> c = new C();
        B b = c.doSomething();  /* ClassCastException */
    }
}
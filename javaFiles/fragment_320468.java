public interface Foo {
    // Methods here
}

public class FooFactory {

    public static Foo getFoo1() {
        return new Foo1();
    }

    public static Foo getFoo2() {
        return new Foo2();
    }

    private static abstract class AbstractFoo implements Foo {
        // Implement methods in Foo in terms of 
        // doSomething()...

        // Implementation-specific method
        public abstract void doSomething();
    }

    private static class Foo1 extends AbstractFoo {
        public void doSomething() {
        }
    }

    private static class Foo2 extends AbstractFoo {
        public void doSomething() {
        }
    }
}
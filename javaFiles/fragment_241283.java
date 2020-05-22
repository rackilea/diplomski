public class Foo {
    private boolean needsGreeting = true;

    public synchronized void greet() {
        if (needsGreeting) {
            System.out.println("Hello.");
            needsGreeting = false;
        }
    }
}

class FooUser {
    private static Foo foo;

    public static Foo getFoo() {
        if (foo == null) {
            synchronized (FooUser.class) {
                if (foo == null) {
                    foo = new Foo();
                }
            }
        }
        return foo;
    }
}
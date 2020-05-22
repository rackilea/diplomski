abstract class Base {
    public static <T extends Base> T createCopy(final T t,
            final Class<T> klass) {
        if (t instanceof A) {
            final T copy = klass.cast(new A((A) t));
            return copy;
        }

        if (t instanceof B) {
            final T copy = klass.cast(new B((B) t));
            return copy;
        }

        throw new IllegalStateException();
    }
}

class A extends Base {
    public A() {
    }

    public A(final A a) {
    }
}

class B extends Base {
    public B() {
    }

    public B(final B b) {
    }
}
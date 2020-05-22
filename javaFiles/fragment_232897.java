@FunctionalInterface
interface Foo {
    void method1(int x);
}

public class Example {
    public static final void main(String[] args) {
        new Example().testFoo(x -> {
            System.out.println(x);
        });
    }

    private void testFoo(Foo f) {
        for (int x = 0; x < 5; ++x) {
            f.method1(x);
        }
    }
}
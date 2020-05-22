public class Foo {
    private static int fooCount = 0;

    public Foo() {
        if (this.getClass() == Foo.class) {
            fooCount++;
        }
    }

    public static int getFooCount() {
        return fooCount;
    }
}
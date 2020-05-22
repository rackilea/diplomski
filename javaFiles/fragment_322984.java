import java.lang.reflect.*;
public class Foo {
    interface IFoo { public int get(); }

    public static IFoo build2(final int v) {
        return new IFoo() { public int get() {return v;} };
    }
    public static void main(String[] args) throws Exception {
        Class<?> klazz = build2(42).getClass();
        for (Constructor<?> c : klazz.getDeclaredConstructors()) {
            System.out.println(c);
        }
        // prints: Foo$1(int)
    }
}
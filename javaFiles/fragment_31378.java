package bar;
import foo.Foo;

public class Bar {
    public static void main(String[] args) {
        Foo foo1 = new Foo(1);
        Foo foo2 = new Foo(2);

        // prints "class Foo::foo # 1"
        foo1.foo();
        // prints "class Foo::foo # 2"
        foo2.foo();
        // prints "object Foo::fooStatic"
        Foo.fooStatic();
    }
}
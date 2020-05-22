public abstract class Foo {
    protected Foo(int value) {
       ... use value ...
   }
}

public class Bar extends Foo {
    public Foo(int value) {
        super(value);
    }
    ...
}
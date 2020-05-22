package a;

class Base {
    protected void bang() {
    }
}

package a;

public class Foo extends Base {
}

package b;

public class Bar extends Foo {
    @Override
    protected void bang() {
    }
}
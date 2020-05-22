//base class to be decorated
abstract class Foo {
    private int x;
    protected Foo foo;
    public int getX() { return this.x; }
    public void setX(int x) { this.x = x; }
    public Foo getFoo() { return this.foo; }

    //method to prove the difference between using getter and simple value
    public final void printInternalX() {
        if (foo != null) {
            System.out.println(foo.x);
            System.out.println(foo.getX());
        }
    }
}

//specific class implementation to be decorated
class Bar extends Foo {
    @Override
    public int getX() {
        return super.getX() * 10;
    }
}

//decorator
class Baz extends Foo {
    public Baz(Foo foo) {
        this.foo = foo;
    }
}

public class Main {
    public static void main(String[] args) {
        Foo foo1 = new Bar();
        foo1.setX(10);
        Foo foo2 = new Bar(foo1);
        //here you see the difference
        foo2.printInternalX();
    }
}
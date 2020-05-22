public class Foo {
    public Foo () {
        System.out.println(Bar.getSomeVal());
    }
}

public class Bar {
    private static int someVal;
    public Bar () {
    }

    public stating int getSomeVal() { // this is just an example static method.
        return Bar.someVal;
    }
}
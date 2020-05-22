public class Foo {
    private Bar bar = new Bar();

    public Foo () {
        this.bar.getSomeVal();
    }
}

public class Bar {
    private int someVal;
    public Bar () {
        this.someVal = 10;
    }

    public int getSomeVal() { // this is just an example method.
        return this.someVal;
    }
}
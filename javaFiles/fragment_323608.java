public class Test {
    public static void main(String[] args) throws Exception {
        Foo foo = new Bar();
        Foo copyOfFoo = createCopyOfFoo(foo);
        System.out.println(copyOfFoo);
    }


    private static Foo createCopyOfFoo(Foo foo) throws CloneNotSupportedException {
        Foo clone = (Foo) foo.clone();
        return clone;
    }
}

class Foo implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Bar extends Foo {
    private int x = 1;

    @Override
    public String toString() {
        return "Bar [x=" + x + "]";
    }
}
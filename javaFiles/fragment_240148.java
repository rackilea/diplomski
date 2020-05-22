public class Test {
    public static void main(final String[] args) {
        B b = new B();
        b.print();
    }
}

abstract class A {

    protected abstract int getX();

    public void print() {
        System.out.println(getX());
    }
}

class B extends A {
    private final int x = 10;

    @Override
    protected int getX() {
        return x;
    }
}
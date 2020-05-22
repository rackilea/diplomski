public class Test {
    public static void main(final String[] args) {
        B b = new B();
        System.out.println(b);
    }
}

abstract class A {

    protected abstract int getX();

    @Override
    public String toString() {
        return String.valueOf(getX());
    }
}

class B extends A {
    private static final int X = 10;

    @Override
    protected int getX() {
        return X;
    }
}
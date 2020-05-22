public class Test {
    public static void main(final String[] args) {
        B b = new B();
        System.out.println(b);
    }
}

interface MyInterface {
    int getX();
}

abstract class A implements MyInterface{
    @Override
    public String toString() {
        return String.valueOf(getX());
    }
}

class B extends A {
    private static final int X = 10;

    @Override
    public int getX() {
        return X;
    }
}
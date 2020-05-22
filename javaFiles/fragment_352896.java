public class MyTest2 {
    public static void main(final String[] args) {
    B b = new B();
    System.out.println(b);
    }
}

interface MyInterface<T> {
    int getX();
}

abstract class A<T> implements MyInterface {
    @Override
    public String toString() {
    return String.valueOf(getX());
    }
}

class B extends A<C>  {
    private static final int X = 10;

    @Override
    public int getX() {
    return X;
    }
}

class C  {
    // This is concrete class some
}
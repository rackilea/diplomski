public abstract class A implements I {
    @Override 
    public double foobar() { 
        return privateFoobar();
    }

    private double privateFoobar() {
        /* return foo */
    }

    @Override public void print() {
        System.out.print(privateFoobar());   
    }
}

public class B extends A {
    @Override public double foobar() { /*return bar*/ }
    @Override public void print() {
        super.print();
        System.out.print(foobar());
    }
}
public class A {
    public void sum() { System.out.println("A.sum()"); }
}

public class B extends A {
    @Override
    public void sum() { System.out.println("B.sum()"); }
    protected final void superSum() { super.sum(); }
}

public class C extends B {
    @Override
    public void sum() { System.out.println("C.sum()"); }
    public void someMethod() {
        sum();
        super.sum();
        superSum();
    }
}
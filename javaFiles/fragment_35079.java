public class Class1 {
    private void test () { System.out.println ("test"); }
    public void doThis (Class2 c) {
        // c.test();  -- does not compile [1]
        ((Class1)c).test();
    }
}

public class Class2 extends Class1 {
    public void doSomething () {
        doThis (this);
        // ((Class1)this).test();  -- does not compile [2]
    }
}
public class B {

    @ManyToOne
    private A a;

    public void foo() {
        A a = new A();
        B b = new B();
        b.setA(a); // Instead of a.getFoo().add(b);
        // Persist b in database...
    }

}
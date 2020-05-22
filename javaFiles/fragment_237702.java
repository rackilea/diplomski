public class A {

    private B b;

    private C c;

    public A(B b,C c)
    {
        this.b=b;
        this.c=c;
    }

    void method() {
        System.out.println("A's method called");
        b.method();
        c.method();
        System.out.println(method2());

    }

    protected int method2() {
        return 10;
    }
}
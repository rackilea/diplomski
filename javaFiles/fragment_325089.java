public class A {
    protected void init(int a) {}

    static public A create( int a)
    {
        A o = new A();
        o.init( a );
        return o;
    }
}

public class B extends A {

    protected void init( int a, int b )
    {
        super.init( a );
    }

    static public B create( int a, int b)
    {
        B o = new B();
        o.init( a, b );
        return o;
    }
}
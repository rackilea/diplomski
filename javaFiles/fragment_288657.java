public class A
{
    public static Number foo(){ return 0.1f; }
}

public class B extends A
{
}

public class C
{
    static Object x = B.foo();    
}
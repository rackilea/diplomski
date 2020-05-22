class Base
{
    void foo(int x)
    {
        System.out.println("Base.foo(int)");
    }

    void foo(double d)
    {
        System.out.println("Base.foo(double)");
    }
}

class Child extends Base
{
    @Override void foo (int x)
    {
        System.out.println("Child.foo(int)");
    }
}

...

Base b = new Child();
b.foo(10); // Prints Child.foo(int)
b.foo(5.0); // Prints Base.foo(double)
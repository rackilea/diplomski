interface Interface1
{
    public void g();
}

interface Interface2
{
    public void f();
}

class MyClass implements Interface1, Interface2
{
    @Override
    public void g()
    {
        class InnerClass implements Interface2
        {
            @Override
            public void f()
            {
            }
        }
    }
}
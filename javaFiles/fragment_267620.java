public static void main(String[] args)
{
    Foo f = new Foo();
    Boo b = new Boo(f);
    f.setBoo(b);
}

class Foo
{
    private Boo b;

    public Foo()
    {
        // ...
    }

    public void setBoo(Boo b)
    {
        this.b = b;
    }
}

class Boo
{
    private Foo f;

    public Boo(Foo f)
    {
        this.f = f;
    }
}
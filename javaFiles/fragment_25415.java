class Bar
{
    public void doSomething() { /* ... */ }
}

class Foo
{
    private Runnable runnable;

    Foo(Runnable runnable)
    {
        this.runnable = runnable;
    }

    public void onCompletion()
    {
        this.runnable.run();
    }
}

Bar bar = new Bar();
Foo foo = new Foo(bar::doSomething);
foo.onCompletion();
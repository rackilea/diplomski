interface IFoo
{
    void doFoo();
    IFoo NULL_FOO = new NullFoo();

    final class NullFoo implements IFoo
    {
        public void doFoo () {};
        private NullFoo ()  {};
    }
}


...
IFoo foo = IFoo.NULL_FOO;
...
bar.addFooListener (foo);
...
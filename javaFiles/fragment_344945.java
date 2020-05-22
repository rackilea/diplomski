abstract class Generic2<T>: IGeneric2<T> where T : Impl
{
    protected INotGeneric1 elem;

    // It's highly likely that you would want to change the type of val
    // to INotGeneric1 as well, there's no obvious reason to require an
    // IGeneric1<U>
    public void method2<U>(IGeneric1<U> val) where U : Impl
    {
        elem = val; // this is now OK
    }
}
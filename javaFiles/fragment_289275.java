interface IInterf { }

class Impl : IInterf { }

interface IGeneric1<T> where T:Impl {
    void method1<U>(IGeneric2<U> val) where U:Impl;
    void method1WithParam(T to);
}

interface IGeneric2<T>where T:Impl {
    void method2<U>(IGeneric1<U> val) where U:Impl;
}

abstract class Generic<T> : IGeneric1<T>, IGeneric2<T> where T : Impl
{
    public void method1<U>(IGeneric2<U> val2) where U:Impl
    {
        val2.method2(this);
    }

    public abstract void method1WithParam(T to);
    public abstract void method2<U>(IGeneric1<U> val) where U:Impl;
}
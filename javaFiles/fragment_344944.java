// C# code:
interface INotGeneric1 {
    void method1<T>(IGeneric2<T> val) where T : Impl;
}

interface IGeneric1<T> : INotGeneric1 where T : Impl {
    T method1WithParam(T to);
}
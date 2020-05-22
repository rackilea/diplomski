public abstract class MyClassIterator<T> extends MyClass
{
    protected abstract void monitor(T data);

    protected void monitor() {
        //optional
        throw new UnsupportedOperationException();
    }
}
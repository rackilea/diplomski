public class Foo {
    private volatile int modCount = 0;
    public void threadUnsafeMethod() {
        int startModCount = ++modCount;
        ...
        if (modCount != startModCount) { throw new ConcurrentModificationException(); }
    }
}
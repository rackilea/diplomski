public class Foo {
    private final AtomicBoolean inThreadUnsafeMethod = new AtomicBoolean();
    public void threadUnsafeMethod() {
        if (!inThreadUnsafeMethod.compareAndSet(false, true) {
            throw new ConcurrentModificationException();
        }
        try {
            ...
        } finally {
            inThreadUnsafeMethod.set(false);
        }
    }
}
public class MyGeneric<T> {
    private T val;
    public T get() {
        return this.val;
    }
    public void set(T val) {
        this.val = val;
    }
}
public class Box<T extends Number> {
    public T get() {
        return element;
    } 

    public void put(T element) {
        this.element = element;
    }

    public void put(Box<? extends T> box) {
        put((T) box.get());
    }

    private T element;
}
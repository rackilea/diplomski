public class Location<T extends Location<?>> {
    protected int x, y;

    @SuppressWarnings("unchecked")
    public T setX(int x) {
        this.x = x;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T setY(int y) {
        this.y = y;
        return (T) this;
    }
}
public class Handler<T> {
    private int required;
    private Handler<?> next;
    private Class<? extends T> c;

    public Handler(Class<? extends T> c) {
        this.c = c;
    }

    public void handle(Object o) {
        if (c.isInstance(o)) {
            required--;
        } else {
            next.handle(o);
        }
    }

    // ...
}
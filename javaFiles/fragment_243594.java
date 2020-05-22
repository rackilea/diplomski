public class Recursive<T> {
    List<Recursive<T>> sub;
    T value;

    boolean hasSub() {
        return sub != null;
    }
    T getValue() {
        return value;
    }
    void forEach(Consumer<T> t) {
        if (hasSub())
            sub.forEach(t);
        else t.accept(value);
    }
}
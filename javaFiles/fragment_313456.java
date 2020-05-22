public class Generic5<T extends Runnable & Comparable> {
    T t;
    Comparable comparable;

    Generic5(T t) {
        this.t = t;
    }

    Generic5(Comparable comparable) {
        this.comparable = comparable;
    }
}
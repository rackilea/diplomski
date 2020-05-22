public abstract class Scope<E extends Comparable<E>> {
    abstract Scope<E> create(E start, E end);

    public Scope<E> crop(Scope<E> scope) {
        ...
        return create(starts, ends);
    }
}
public TimeRange extends Scope<Date> {
    Scope<Date> create(Date start, Date end) {
        return new TimeRange (...);
    }
}
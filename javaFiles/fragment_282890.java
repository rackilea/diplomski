public abstract class Scope<THIS extends Scope<THIS, E>, E extend Comparable<E>> {
    abstract THIS create(E start, E end);

    public THIS crop(Scope<E> scope) {
        ...
        return create(starts, ends);
    }
}
public TimeRange extends Scope<TimeRange,Date> {
    TimeRange create(Date start, Date end) {
        return new TimeRange (...);
    }
}
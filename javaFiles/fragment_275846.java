// Note: not null-safe. (See below.)
public final class UnorderedPair<T> {
    private final T first;
    private final T second;

    public UnorderedPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    @Override public int hashCode() {
        return first.hashCode() + second.hashCode();
    }

    @Override public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UnorderedPair)) {
            return false;
        }

        UnorderedPair<?> otherPair = (UnorderedPair<?>) other;
        return (first.equals(otherPair.first) && second.equals(otherPair.second))
            || (first.equals(otherPair.second) && second.equals(otherPair.first));
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
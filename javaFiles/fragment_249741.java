public class Range<T extends Comparable<T>> {

    private final T min;
    private final T max;

    public Range( T min, T max ) {
        this.min = min;
        this.max = max;
    }

    public boolean within( T value ) {
        return min.compareTo(value) <= 0 && max.compareTo(value) >= 0;
    }
}
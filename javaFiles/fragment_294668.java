abstract class Range<T extends Number & Comparable<T>> {
    protected T v1;
    protected T v2;
    public Range(T v1, T v2) {
        if (v1.compareTo(v2) > 0)
            throw new IllegalArgumentException("Value-1 must be smaller or equal to Value-2.");
        this.v1 = v1;
        this.v2 = v2;
    }

    public abstract T length(); 
}
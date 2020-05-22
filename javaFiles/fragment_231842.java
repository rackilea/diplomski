// T must be a subclass of Number
// AND implement Comparable
Example<T extends Number & Comparable<T>>
        implements Comparable<Example<T>> {
    ...
    @Override
    public int compareTo(Example<T> that) {
        return this.num.compareTo(that.num);
    }
}
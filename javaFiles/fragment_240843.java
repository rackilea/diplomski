class BaseComparable implements Comparable<Base> {
    private final Base key;
    // other fields

    BaseComparable(Base key, ...) {
        this.key = key;
        // other fields initialization
    }

    @Override
    public int compareTo(Base otherKey) {
        return this.key.compareTo(otherKey);
    }
};
public final class Key2<K1, K2> {
    private final K1 part1;
    private final K2 part2;

    public Key2(K1 part1, K2 part2) {
        this.part1 = part1;
        this.part2 = part2;
    }

    @Override public boolean equals(Object other) {
        if (!(other instanceof Key2)) {
            return false;
        }
        // Can't find out the type arguments, unfortunately
        Key2 rawOther = (Key2) other;
        // TODO: Handle nullity
        return part1.equals(rawOther.part1) &&
            part2.equals(rawOther.part2);
    }

    @Override public int hashCode() {
        // TODO: Handle nullity
        int hash = 23;
        hash = hash * 31 + part1.hashCode();
        hash = hash * 31 + part2.hashCode();
        return hash;
    }

    // TODO: Consider overriding toString and providing accessors.
}
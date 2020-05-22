NavigableSubMap(TreeMap<K,V> m,
                boolean fromStart, K lo, boolean loInclusive,
                boolean toEnd,     K hi, boolean hiInclusive) {
    if (!fromStart && !toEnd) {
        if (m.compare(lo, hi) > 0)
            throw new IllegalArgumentException("fromKey > toKey");
    } else {
        if (!fromStart) // type check
            m.compare(lo, lo);
        if (!toEnd)
            m.compare(hi, hi);
    }

    this.m = m;
    this.fromStart = fromStart;
    this.lo = lo;
    this.loInclusive = loInclusive;
    this.toEnd = toEnd;
    this.hi = hi;
    this.hiInclusive = hiInclusive;
}
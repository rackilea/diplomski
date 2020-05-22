private static Set<BitSet> powerset(BitSet set) {
    Set<BitSet> sets = new HashSet<>();
    if (set.isEmpty()) {
        sets.add(new BitSet(0));
        return sets;
    }
    Integer head = set.nextSetBit(0);
    BitSet rest = set.get(0, set.size());
    rest.clear(head);
    for (BitSet s : powerset(rest)) {
        BitSet newSet = s.get(0, s.size());
        newSet.set(head);
        sets.add(newSet);
        sets.add(s);
    }
    return sets;
}
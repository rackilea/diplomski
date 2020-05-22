static IntStream distinct(IntStream s) {
    boolean parallel=s.isParallel();
    s=s.collect(BitSet::new, BitSet::set, BitSet::or).stream();
    if(parallel) s=s.parallel();
    return s;
}
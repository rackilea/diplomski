List<boolean[]> bool(int n) {
    return IntStream.range(0, (int)Math.pow(2, n))
        .mapToObj(i -> new long[] { i })
        .map(BitSet::valueOf)
        .map(bs -> bitSetToArray(bs, n))
        .collect(toList());
}
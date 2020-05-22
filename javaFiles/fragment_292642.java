boolean[] bitSetToArray(BitSet bs, int width) {
    boolean[] result = new boolean[width]; // all false
    bs.stream().forEach(i -> result[i] = true);
    return result;
}

List<boolean[]> bool(int n) {
    return IntStream.range(0, (int)Math.pow(2, n))
        .mapToObj(i -> bitSetToArray(BitSet.valueOf(new long[] { i }), n))
        .collect(toList());
}
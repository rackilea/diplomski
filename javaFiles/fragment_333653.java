int[] split(int input) {
    return IntStream.iterate(Integer.reverse(1), mask -> mask >>> 1)
            .limit(Integer.SIZE)
            .map(mask -> input & mask)
            .filter(result -> result != 0)
            .toArray();
}
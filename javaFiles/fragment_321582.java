public static int[] calculateRanks(int... arr) {
    class Pair {
        final int value;
        final int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    Pair[] pairs = new Pair[arr.length];
    for (int index = 0; index < arr.length; ++index) {
        pairs[index] = new Pair(arr[index], index);
    }

    Arrays.sort(pairs, (o1, o2) -> -Integer.compare(o1.value, o2.value));

    int[] ranks = new int[arr.length];
    int rank = 1;
    for (Pair pair : pairs) {
        ranks[pair.index] = rank++;
    }

    return ranks;
}
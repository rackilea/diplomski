public static void main(String... args) throws IOException {
    final int rows = 40 * 1000;
    final int cols = 900;

    List<BitSet> features = new ArrayList<BitSet>();
    features.add(new BitSet(rows));
    features.add(new BitSet(rows));
    for (int i = 2; i < cols; i++) {
        final BitSet bs = new BitSet(rows);
        for (int j = 0; j < rows; j++)
            bs.set(j, j % i == 0);
        features.add(bs);
    }

    // perform the search
    int[] factors = new int[]{2, 5, 7};
    BitSet matches = new BitSet();
    long runs =  1000*1000;
    {
        long start = System.nanoTime();
        for (int i = 0; i < runs; i++) {
            // perform lookup.
            lookup(matches, features, factors);
        }
        long avgTime = (System.nanoTime() - start) / runs;
        System.out.println("average search time " + avgTime  + " ns.");
    }
    {
        long start = System.nanoTime();
        int count9 = 0;
        BitSet col9matched = new BitSet(cols);
        for (int i = 0; i < runs; i++) {
            final int index = 9;
            final BitSet feature = features.get(index);
            count9 = countMatches(col9matched, matches, feature);
        }
        long avgTime = (System.nanoTime() - start) / runs;
        System.out.println("average count time " + avgTime + " ns.");
    }
}

private static int countMatches(BitSet scratch, BitSet matches, BitSet feature) {
    // recycle.
    scratch.clear();
    scratch.or(matches);
    scratch.and(feature);
    return scratch.cardinality();
}

private static void lookup(BitSet matches, List<BitSet> data, int[] factors) {
    matches.clear();
    matches.or(data.get(factors[0]));
    for (int i = 1, factorsLength = factors.length; i < factorsLength; i++) {
        matches.and(data.get(factors[i]));
    }
}
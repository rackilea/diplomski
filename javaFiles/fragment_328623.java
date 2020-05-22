void process(int idx, int n, int[][] x, int[] k, Object[] ntuple) {
    if (idx == n) {
        // we have a complete n-tuple, 
        // with an element from each of the n arrays
        f(ntuple);
        return;
    }

    // this is the idx'th "for" statement
    for (int i = 0; i < k[idx]; i++) {
        ntuple[idx] = x[idx][i];
        // with this recursive call we make sure that 
        // we also generate the rest of the for's
        process(idx + 1, n, x, k, ntuple);
    }
}
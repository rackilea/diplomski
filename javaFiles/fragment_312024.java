public static int[][] subSeqs(boolean[] vals, int n) {
    List<int[]> result = new ArrayList<>();
    int i = -1;
    for (int j = 0; j <= vals.length; j++) {
        boolean b = j == vals.length ? false : vals[j];
        if (b && i == -1) {          // going from false to true
            i = j;
        } else if (!b && i != -1) {  // going from true to false
            if (j-i >= n)
                result.add(new int[] { i, j-1 });
            i = -1;
        }
    }
    return result.toArray(new int[result.size()][]);
}
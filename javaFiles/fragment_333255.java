static int maxConsecutive(int[] a) {
    Arrays.sort(a);

    int max = 0;
    int start = 0;
    for (int i = 0; i < a.length; i++)
        if (a[i] - a[start] == i - start) max = Math.max(max, i - start + 1);
        else start = i;

    return max;
}

static long process(int rows, int cols, int[] hor, int[] ver) {
    long maxH = maxConsecutive(hor);
    long maxV = maxConsecutive(ver);
    return (maxH + 1) * (maxV + 1);
}
int[] a = {1, 2};
int max = 1 << a.length;
int[][] result = new int[max][];
for (int i = 0; i < max; ++i) {
    result[i] = new int[Integer.bitCount(i)];
    for (int j = 0, b = i, k = 0; j < a.length; ++j, b >>= 1)
        if ((b & 1) != 0)
            result[i][k++] = a[j];
}
System.out.println(Arrays.deepToString(result));
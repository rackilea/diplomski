public static int[] plusOne(int[] x) {
    int[] y = new int[x.length];
    System.arraycopy(x, 0, y, 0, x.length);

    for (int i=0; i < x.length; ++i) {
        y[i] = x[i] + 1;
    }

    return y;
}
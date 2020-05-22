public static void main(String[] args) throws Exception {
    int[] v = { 1, 3, 5 };
    int[] w = { 2, 4, 6 };
    int[] res = splice(v, w);
    System.out.println(Arrays.toString(res));
}

private static int[] splice(int[] v, int[] w) {
    if (v.length != w.length) {
        return null;
    }
    int[] a = new int[v.length + w.length];
    for (int i = 0; i < v.length; i++) {
        a[i * 2] = v[i];
        a[i * 2 + 1] = w[i];
    }
    return a;
}
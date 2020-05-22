private static void findSum(int[] a, int[] b, int x) {
    Map<Integer, Integer> bIdx = new HashMap<>();
    for (int j = 0; j < b.length; j++)
        bIdx.put(b[j], j);
    for (int i = 0; i < a.length; i++) {
        Integer j = bIdx.get(x - a[i]);
        if (j != null)
            System.out.println("a[" + i + "] + b[" + j + "] = " + a[i] + " + " + b[j] + " = " + x);
    }
}
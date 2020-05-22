private static void findSum(int[] a, int[] b, int x) {
    for (int i = 0, j = b.length - 1, sum; i < a.length && j >= 0; i++) {
        while (j >= 0 && (sum = a[i] + b[j]) >= x) {
            if (sum == x)
                System.out.println("a[" + i + "] + b[" + j + "] = " + a[i] + " + " + b[j] + " = " + x);
            j--;
        }
    }
}
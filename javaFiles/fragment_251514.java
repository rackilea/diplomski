public static int[] getCombo(int n, int r, int k) {
    int[] result = new int[r];
    int cur = 1;
    int sum =0;
    while (r > 0) {
        int tot = c(n - cur, r - 1);
        if (sum + tot < k) {
            sum += tot;
            cur++;
        } else {
            result[result.length - r] = cur++;
            r--;
        }
    }
    return result;
}
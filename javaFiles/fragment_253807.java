public static boolean nextCombinationRecursive (int j, int x[], int k, int n) {
    if (j < 0 || j > k) return false;

    if (x[j] <= (n - k + j)) {
        x[j]++;  
        for (int i = 1; i < k - j;  i++)
            x[i+j] = x[j]+i;
        return true; 
    }

    return nextCombinationRecursive(j - 1, x, k, n);
}
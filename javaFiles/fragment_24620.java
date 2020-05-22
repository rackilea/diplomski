public int sumOfArray(int[] a, int n) {
    if (n == 0)
        return a[n];
    else
        return a[n] + sumOfArray(a, n-1);
}
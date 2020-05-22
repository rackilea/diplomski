double[] a = new double[n + 1]; // initialized to zeros
for (int k = n; k >= 0; --k) {
    for (int i = n - k; i > 0; --i)
        a[i] = a[i - 1] - x[k]*a[i];
    a[0] = c[k] - x[k]*a[0];
}
for (int k = 0; k < n - 1; k++) {
    if (q != k)
        x2[k] = x[k];
    if (q == k)
        x2[k] = x[k + 1];
}
for (int k = 0; k < q; k++) {
    x2[k] = x[k];
}
for (int k = q; k < n - 1; k++) {
    x2[k] = x[k+1];
}
// k <= m
if (...) {
    swap(a, k, m);
    // m <= old m // if call-by-reference

    k = k + 1;
    // k - 1 <= m if call-by-value
}
m = m + 1;
// k <= m again; if call-by-value
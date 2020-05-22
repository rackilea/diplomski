int result = cache[n];
if (result == 0) {
    for (int i = 0; i < n; i++) {
        result += memCat(i, cache) * memCat(n - i - 1, cache);
    }
    cache[n] = result;
}
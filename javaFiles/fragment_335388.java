powMod(a, b, m) {
    result = 1
    for (i = 0; i < b; i++) {
        result = (result * a) % m
    }
    return result
}
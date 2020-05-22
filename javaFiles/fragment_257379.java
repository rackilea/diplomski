boolean has_a_representation(int n) {
    return has_a_representation(n, Integer.MAX_VALUE);
}
boolean has_a_representation(int n, int max_exponent) {
    if (n == 0)
        return true;
    for (int digit: allowedNumbers) {
        int power = digit;
        for (int exp = 1; exp < max_exponent && power <= n; ++exp) {
            if (has_a_representation(n - power, exp))
                return true;
            power *= digit;
        }
    }
    return false;
}
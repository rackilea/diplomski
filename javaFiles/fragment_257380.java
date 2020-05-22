boolean has_a_representation(int n) {
    return has_a_representation(n, 1);
}
boolean has_a_representation(int n, int exp) {
    for (int digit: allowedNumbers) {
        int power = digit;
        for (int i = 1; i < exp; ++i)
            power *= digit;
        if (n == power)
            return true;
        if (n < power) // allowedNumbers must be sorted
            break;
        if (has_a_representation(n - power, exp + 1))
            return true;
    }
    return false;
}
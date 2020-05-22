private static long sumProduct(int... input) {
    long result = 0;
    for (int value : input)
        result += (result + 1) * value;
    return result;
}
public static String bitConversion(int x) {
    // just simplifying my life here as negative numbers can be represented
    // in a few ways and usually it's additive code I don't want to deal
    // with here :)
    if (x < 0) {
        throw new IllegalArgumentException("Not implemented for negatives");
    }

    // recursion termination condition for 0 and 1
    if (x <= 1) {
        return String.valueOf(x);
    }

    // recurision
    int leastSignificantBit = x % 2;
    String significantBits = bitConversion(x / 2);
    return significantBits + leastSignificantBit;
}
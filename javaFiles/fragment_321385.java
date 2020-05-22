private static boolean isInteger(double n) {
    if (n > (double) Long.MAX_VALUE ||  n < (double) Long.MIN_VALUE) {
        return true;
    }
    long asLong = (long) n;
    return n == (double) asLong;
}
public boolean isPowerOfTwo(BigInteger n) {
    if (n.compareTo(BigInteger.ZERO) <= 0) {
        return false;
    }
    return (n.and(n.subtract(BigInteger.ONE))).equals(BigInteger.ZERO);
}
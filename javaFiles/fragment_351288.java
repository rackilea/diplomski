public static BigInteger parseBigIntegerPositive(String num, int bitlen) {
    if (bitlen < 1)
        throw new RuntimeException("Bad bit length:" + bitlen);
    BigInteger bref = BigInteger.ONE.shiftLeft(bitlen);
    BigInteger b = new BigInteger(num);
    if (b.compareTo(BigInteger.ZERO) < 0)
        b = b.add(bref);
    if (b.compareTo(bref) >= 0 || b.compareTo(BigInteger.ZERO) < 0 )
        throw new RuntimeException("Out of range: " + num);
    return b;
}
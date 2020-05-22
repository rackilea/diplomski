public static BigInteger parseBigIntegerPositive(String num,int bitlen) {
    BigInteger b = new BigInteger(num);
    if (b.compareTo(BigInteger.ZERO) < 0)
        b = b.add(BigInteger.ONE.shiftLeft(bitlen));
    return b;
}
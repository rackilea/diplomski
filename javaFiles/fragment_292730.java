public static BigInteger random(Random rand, BigInteger minValue, BigInteger maxValue) {
    BigInteger range = maxValue.subtract(minValue).add(BigInteger.ONE);
    int bits = range.bitLength();
    BigInteger ret;
    do {
        ret = new BigInteger(bits, rand);
    } while(ret.compareTo(range) >= 0);
    return ret.add(minValue);
}
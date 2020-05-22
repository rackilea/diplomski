static int testMod(int a, int mod) {
    BigInteger bigA = BigInteger.valueOf(a);
    BigInteger bigMod = BigInteger.valueOf(mod);

    return bigA.modPow(BigInteger.valueOf(4), bigMod).intValue();
}
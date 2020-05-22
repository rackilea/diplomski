public static BigInteger getPrivateExponent(byte[] publicExponentBytes, byte[] pBytes, byte[] qBytes) {
    BigInteger e = new BigInteger(1, publicExponentBytes);
    BigInteger p = new BigInteger(1, pBytes);
    BigInteger q = new BigInteger(1, qBytes);

    BigInteger pSub1 = p.subtract(BigInteger.ONE);
    BigInteger qSub1 = q.subtract(BigInteger.ONE);
    BigInteger phi = pSub1.multiply(qSub1);
    return e.modInverse(phi);
}
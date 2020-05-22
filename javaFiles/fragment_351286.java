// Two's complement reference: 2^n . 
// In this case, 2^64 (so as to emulate a unsigned long)
private static final BigInteger TWO_COMPL_REF = BigInteger.ONE.shiftLeft(64);

public static BigInteger parseBigIntegerPositive(String num) {
    BigInteger b = new BigInteger(num);
    if (b.compareTo(BigInteger.ZERO) < 0)
        b = b.add(TWO_COMPL_REF);
    return b;
}

public static void main(String[] args) {
    System.out.println(parseBigIntegerPositive("-1").toString(16));
}
public static void main(String[] args) {
    final BigInteger TWO = new BigInteger("2");
    BigInteger k = BigInteger.ONE;
    BigInteger n = new BigInteger(args[0]);
    if (n.compareTo(BigInteger.ZERO) < 0) {
        System.out.println("< 0");
    } else {
        while (k.compareTo(n) <= 0) {
            k = k.multiply(TWO);
            if (k.compareTo(n) <= 0) {
                System.out.println(k);
            } else {
                System.out.println();
            }
        }
    }
}
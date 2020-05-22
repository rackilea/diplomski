public static String factorialAsBinary(int n) {
    BigInteger bi = BigInteger.ONE;
    for (; n > 1; n--)
        bi = bi.multiply(BigInteger.valueOf(n));
    return bi.toString(2);
}

public static void main(String... args) {
    String fact36 = factorialAsBinary(36);
    for (char ch : fact36.toCharArray())
        System.out.print(ch + " ");
    System.out.println();
}
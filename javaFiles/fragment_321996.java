public static void byHundred(int n) {
    BigInteger bi = BigInteger.valueOf(n);
    String result = bi.pow(100).toString();
    System.out.println(result);
}

public static void main(String[] args) {
    byHundred(23);
}
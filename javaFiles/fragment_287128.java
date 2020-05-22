public static void main(String[] args) {
    BigInteger integer = BigInteger.valueOf(60000);

    String result = NumberFormat.getNumberInstance(Locale.US).format(
            integer);
    System.out.println(result);
}
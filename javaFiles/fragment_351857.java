public static void main(String[] args) throws ParseException {
    BigInteger big = BigInteger.valueOf(3).pow(1002);
    String s = big.toString();
    System.out.println("3^1002 :-" + big);
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
        sum = sum + Integer.parseInt(String.valueOf(s.charAt(i)));

    }
    System.out.println("Sum of digits = "+sum);
}
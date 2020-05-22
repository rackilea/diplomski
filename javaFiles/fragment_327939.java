public static BigInteger factorialOf(int x) {
    BigInteger answer = BigInteger.ONE;
    for(int i = 1; i <= x; i++) {
        answer = answer.multiply(BigInteger.valueOf(i));
    }
    System.out.println("The Factorial Of " + x + " is: " + answer);
    return answer;
}

public static int sumOf(BigInteger y) {
    String digits = y.toString();
    int sum = 0;
    for(int i = 0, n = digits.length(); i<n; i++) sum += digits.charAt(i)-'0';
    return sum;
}
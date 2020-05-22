public static BigInteger fibonacci_Loop(int f) {
BigInteger previous = BigInteger.ZERO;
BigInteger current = BigInteger.ONE;

for(int i = 0; i < f-1; i ++) {
    BigInteger sum = previous.add(current);
    previous = current;
    current = sum;
}
return previous;
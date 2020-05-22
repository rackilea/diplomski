BigInteger x = new BigInteger("2");
long totalFactors = 1;
while (x.multiply(x).compareTo(number) <= 0) {
    int power = 0;
    while (number.mod(x).equals(BigInteger.ZERO)) {
        power++;
        number = number.divide(x);
    }
    totalFactors *= (power + 1);
    x = x.add(BigInteger.ONE);
}
if (!number.equals(BigInteger.ONE)) {
    totalFactors *= 2;
}
System.out.println("The total number of factors is: " + totalFactors);
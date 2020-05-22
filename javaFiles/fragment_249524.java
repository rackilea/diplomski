public class BigIntFactorial {

    public static BigInteger factorial(BigInteger number) {
        if(number.equals(BigInteger.ONE)) {
            return BigInteger.valueOf(1);
        } else {
            return number.multiply(factorial(number.subtract(BigInteger.ONE)));
        }
    }

    public static void main(final String... arguments){
        for(Long number=1L;number<=30;number++){

            System.out.println("Factorial of " + number + "  : " + factorial(BigInteger.valueOf(number)));
        }
    }
}
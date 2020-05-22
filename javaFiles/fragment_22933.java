public class Test
{
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        long number = 600851475143L;

        // Start with a divisor of two,
        // continue until over sqrt(number).

        long divisor = 2L;
        while (divisor * divisor <= number) {
            if ((number % divisor) == 0) {
                // If factor, output then reduce number.

                System.out.println(divisor);
                number = number / divisor;
            } else {
                // Otherwise, move to next divisor.

                divisor++;
            }
        }

        // Final number is final divisor.

        System.out.println(number);

        System.out.print("Time used for calculation in nanoseconds: " +
                (System.nanoTime() - startTime) + ".");
    }
}
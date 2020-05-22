public class LargestPrimeFactor 
{

    public static int largestPrimeFactor(long number) {
        int i;

        for (i = 2; i <= number; i++) {
            if (number % i == 0) {
                number /= i;
                i--;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        System.out.println(LargestPrimeFactor.largestPrimeFactor(600851475143l));
    }

}
public class Main
{
    public static void main(String[] args) {
        int k = 0;  // to keep track of how many primes you have prited
        int i = 2;  // number to check for prime, increases every loop
        while (k < 100){  // while you have printed less than 100 primes
            boolean isPrime = true;  // next few lines are checking i for prime and store it in this variable
            for(int divisor = 2; divisor <= i / 2; divisor++) {  // you should go with divisor <= Math.sqrt(i) in condition, I couldn't be bothered in import stuff.
                if (i % divisor == 0) {
                    isPrime = false;
                    break; // i is not a prime, no reason to continue checking
                }
            }
            if (isPrime){
                System.out.println(i);  // if i is prime, print it
                k ++; // increase k by when a print number is found
            }
            i ++; // increase i to check next number
        }
    }
}
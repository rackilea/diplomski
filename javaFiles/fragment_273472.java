private static final int NUM_PRIMES = 1000;
private static final int FIRST_PRIME = 2;
private int[] primes;

public static void generatePrimes() {

    //initialize variables
    primes = new int[NUM_PRIMES];
    int count = 0;
    int number = FIRST_PRIME;

    //loop until the array is full
    while(count < NUM_PRIMES) {

        //if the number is prime
        if(isPrime(number)){

            //add it to the array and increment the array index / prime count
            primes[count] = number;
            count++;
        }

        //increment the number being checked
        number++;
    }
}
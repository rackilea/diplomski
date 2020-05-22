public static void printPrimeNumbers(int numberOfPrimes){
    final int NUMBER_OF_PRIMES_PER_LINE = 10;
    int count = 0;
    int number = 2;
    int sum = ?; 


    while (count < numberOfPrimes){
        //print the prime numbers and increase count
        if (isPrime(number)){
            count++;

            if (count % NUMBER_OF_PRIMES_PER_LINE == 0){
                System.out.printf("%-5s\n", number);
                sum += ?;
            }else {
                System.out.printf("%-5s", number);
            }

        }
        number++;
    }

}

private static boolean isPrime(int number) {
    for (int divisor = 2; divisor <= number / 2 ; divisor++) {
        if (number % divisor == 0){ // if true number is not prime
            return false;
        }
    }
    return true;
}
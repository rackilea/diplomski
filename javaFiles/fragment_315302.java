for(int x = 3; x < 1000; x++) {

    int num = ( (x * (x + 1)) / 2);
    // formula for checking the sum of integers one through x

    if (num%2 == 0) {
        isPrime = false;
    }

    for(int i = 3; isPrime && i < num ; i += 2) {

        if(num % i == 0) {
            isPrime = false;
            // if it's false it is not prime
        }
    }

    if(isPrime == true) {
        System.out.println(x);
        // prints out the original number, the sum of the numbers before it is a prime number
    }
}
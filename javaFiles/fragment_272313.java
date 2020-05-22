public static void countAllDivisors() {

    // Fill the `somePrimeDivisor` array:
    computePrimeDivisors();

    numOfDivisors[1] = 1;
    for (int num = 2 ; num < max_size ; num++) {
        int divisor = somePrimeDivisor[num];
        if (divisor == num) {
            // `num` is a prime
            numOfDivisors[num] = 2;
        } else {
            int n = num / divisor;
            int count = 1;
            while (n % divisor == 0) {
                count++;
                n /= divisor;
            }
            // `divisor^count` contributes to `count + 1` in the number of divisors,
            // now use multiplicative property:
            numOfDivisors[num] = (count + 1) * numOfDivisors[n];
        }
    }
}
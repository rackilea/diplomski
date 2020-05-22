isPrime = true;
for(int divisor = 2; divisor <= num / 2; divisor++) {
    if (num % divisor == 0) {
        isPrime = false;
        break; // num is not a prime, no reason to continue checking
    }
}
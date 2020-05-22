public static int FInd_NthPrime(int n){

    int val = 3;    // first odd number greater than 2
    int result = 0;

    if (n <= 1) {
        return 2;  // special case for 2, the only even prime
    }

    // build up a Hash table of all discovered primes so far
    ArrayList<Integer> primes = new ArrayList<Integer>();
    primes.add(2);

    while (n > 1) {
        if (isPrime(val, primes)) {
            n--;
            result = val;
        }
        val += 2;  // increment to the next odd integer
    }
    return result;
}

public static boolean isPrime(int n, ArrayList<Integer> primes) {

    if (n == 2) {
        return true;
    }

    int stop = (int)Math.sqrt(n);

    for (int divisor : primes) {
        if ((n % divisor) == 0)  {
            return false;
        }
        if (divisor > stop) {
            break;
        }
    }

    //System.out.format("Added %d to prime list\n", n);
    primes.add(n);
    return true;
}
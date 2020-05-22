// finds smallest prime divisor
for (int n = 0; n < Nth_prime; n++) {
    BigInteger modded = y.mod(primes.get(n));
    if (modded.equals(zero)) {
        retval = primes.get(n).intValue();
    }
}
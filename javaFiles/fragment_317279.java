newLatest = current + 1;
while (!isPrime(newLatest)) {
    newLatest++;
}
// newLatest now contains the new prime number.
current = newLatest;
// etc..
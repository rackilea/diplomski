public void SmallerPrimeNumbers() {
    int count = 0;
    for (int i = 0; i <= given_number; i++) {
        if (CheckPrime(i)) {
            System.out.println(i);
        }
    }
}
for (j = 1; j <= 100; j++) {
    isPrime = checkprime(j);
    if (isPrime) {
        isPalindrome = checkpalindrome(j);
        if (isPalindrome) {
            primepalindromes = primepalindromes + j + " ";
        }
    }

}
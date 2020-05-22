public static boolean checkPrime(int n) {
    return checkPrime1(n, 3);
}

public static boolean checkPrime1(int n, int currDivisor) {
    if (n < 2) {
        return false;
    }

    if (n % 2 == 0) {
        return (n == 2);
    }

    if (currDivisor * currDivisor > n) {
        return true;
    }

    if (n % currDivisor == 0) {
        return false;
    }

    return checkPrime1(n, currDivisor + 2);
}
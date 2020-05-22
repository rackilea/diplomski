public boolean isPrime(int number) {
    if (number < 2) {
        return false;
    } else if (number == 2 || number == 3) {
        return true;
    } else if (number % 2 == 0) {
        return false;
    }
    double sq = Math.sqrt(number);
    for (int prime = 3; prime <= sq; prime += 2) {
        if (number % prime == 0) {
            return false;
        }
    }
    return true;
}
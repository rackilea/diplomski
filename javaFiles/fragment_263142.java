public int removeNines(int n) {
    int returnValue = 0, multiplier = 1;
    while (n > 0) {
        if (n%10 != 9) {
            returnValue += (n%10) * multiplier;
            multiplier *= 10;
        }
        n /= 10;
    }
    return returnValue;
}
public static boolean isPrimeNum(int n) {
    for(int j = 2; j < n; j++) {
        if(n % j == 0) {
            return false;
        }
    }
    return true;
}
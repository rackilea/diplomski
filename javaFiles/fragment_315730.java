public static boolean isPowerNumber(int n, double power) {
    int a = (int) Math.pow(n, (1/power));
    if(Math.pow(a,power) == n) {
        return true;
    } else {
        return false;
    }
}
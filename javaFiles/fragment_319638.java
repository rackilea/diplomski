public static int gcd(int a, int b) {
        int temp;
        while(b != 0) {
            temp = a;
            a = b;
            b = temp % b;
        }
        return a;
}
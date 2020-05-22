class Test {
    private static final long P = (long)Math.pow(10, 9) + 7;

    public static void main(String[] args) {
        // Check whether long is suitable in regards to ranges
        System.out.println((int)Math.log10(Long.MAX_VALUE));
        // Your wish up to 10^12, so it's ok!
        int result = calculate(1, (long) Math.pow(10, 12));
        System.out.println(result);

        result = calculate((long) Math.pow(10, 12), (long) Math.pow(10, 12));
        System.out.println(result);
    }

    public static int calculate(long a, long b) {
        return  (int)(gcd(a, b) % P);
    }

    private static long gcd(long p, long q) {
        // https://introcs.cs.princeton.edu/java/23recursion/BinaryGCD.java.html
        if (q == 0) return p;
        if (p == 0) return q;

        // p and q even
        if ((p & 1) == 0 && (q & 1) == 0) return gcd(p >> 1, q >> 1) << 1;

            // p is even, q is odd
        else if ((p & 1) == 0) return gcd(p >> 1, q);

            // p is odd, q is even
        else if ((q & 1) == 0) return gcd(p, q >> 1);

            // p and q odd, p >= q
        else if (p >= q) return gcd((p-q) >> 1, q);

            // p and q odd, p < q
        else return gcd(p, (q-p) >> 1);
    }

    private static long EuclidianGCD(long a, long b) { return b==0 ? a : EuclidianGCD(b, a%b); }

}
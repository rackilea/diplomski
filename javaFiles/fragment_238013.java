public class GCD {
    public static void main(String[] args) {
        int[] ints = { 42, 21, 14, 70 };
        System.out.println(gcd(ints));
    }
    public static int gcd(int[] ints) {
        return Arrays.stream(ints).reduce((a, b) -> gcd(a, b)).getAsInt();
    }
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
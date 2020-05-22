public class SomeClass {
    public static void main(String args[]) {
        int l = 15;
        for(int t = 1; t < 10; ++t) {
            System.out.println(t + " " + l + " => " + toBinString(solve(t, l), l));
        }
    }
    public static String toBinString(int value, int length) {
        String s = "";
        for(int i = 0; i < length; ++i)
            s += (char)('0' + (value >> i & 1));
        return s;
    }
    public static int solve(int t, int l) {
        return ((1 << (l + t - 1)) - 1) / ((1 << t) - 1);
    }
}
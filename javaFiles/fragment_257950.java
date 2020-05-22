public class testprog {
    public static void main (String s[]) {
        float n; int i, x;
        for (i = 0, n = 0.0f; i < 10; i++, n += 0.1f) {
            System.out.print( String.format("%30.29f %08x ",
                n, Float.floatToRawIntBits(n)));
            System.out.println (n);
        }
    }
}
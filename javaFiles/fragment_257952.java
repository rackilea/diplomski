public class testprog {
    public static void outLines (float n) {
        int i, val = Float.floatToRawIntBits(n);
        for (i = -1; i < 2; i++) {
            n = Float.intBitsToFloat(val+i);
            System.out.print( String.format("%30.29f %.08f %08x ",
                n, n, Float.floatToRawIntBits(n)));
            System.out.println (n);
        }
        System.out.println();
    }
    public static void main (String s[]) {
        float n = 0.0f;
        for (int i = 0; i < 6; i++) n += 0.1f;
        outLines (n); n += 0.1f;
        outLines (n); n += 0.1f;
        outLines (n); n += 0.1f;
        outLines (0.7f);
    }
}
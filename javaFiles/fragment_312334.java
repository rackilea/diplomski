public class TestDoubleFloat  {
    public static void main(String[] args) {
        for (long i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i++) {
            float f1 = Float.intBitsToFloat((int) i);
            double d = (double) f1;
            float f2 = (float) d;
            if (f1 != f2) {
                if (Float.isNaN(f1) && Float.isNaN(f2)) {
                    continue; // ok, NaN
                }
                fail("oops: " + f1 + " != " + f2);
            }
        }
    }
}
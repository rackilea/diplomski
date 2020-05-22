public class HailStone {
    public static int iter_count = 0;
    public static void main(String[] args) {
        hailStone(10, true);
    }
    /* Recursive hailStone implementation */
    private static void hailStone(int a, boolean showNumbers) {
        if (showNumbers) {
            System.out.printf("Iteration #%d: %d\n", ++iter_count, a);
        }
        // base case: a = 1
        if (a == 1) {
            return;
        }
        if ((a & 1) == 1) { // a is odd:
            a *= 3;
            a += 1;
        } else {
            a /= 2;
        }
        hailStone(a, showNumbers);
        return;
    }
}
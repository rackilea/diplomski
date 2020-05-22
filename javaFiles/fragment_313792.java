public class Loops {
    final static int L = 100000; // number of iterations per loop

    public static void main(String[] args) {
        int round = 10;
        while (round-- > 0) {
            forLoop();
            doWhileLoop();
            whileLoop();
        }
    }

    private static long whileLoop() {
        int i = 0;
        long s3 = 0;
        while (i++ < L) {
            int j = 0;
            while (j++ < L) {
                s3 += 1;
            }
        }
        return s3;
    }

    private static long doWhileLoop() {
        int i = 0;
        long s2 = 0;
        do {
            int j = 0;
            do {
                s2 += 1;
            } while (++j < L);
        } while (++i < L);
        return s2;
    }

    private static long forLoop() {
        long s1 = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                s1 += 1;
            }
        }
        return s1;
    }
}
/**
 * A demo showing how to do combinations using recursion and memoization, while detecting
 * results that cannot fit in 64 bits.
 */
public class CombinationExample {

    /**
     * Returns the number of combinatios of r things out of n total.
     */
    public static long combi(int n, int r) {
        long[][] cache = new long[n + 1][n + 1];
        if (n < 0 || r > n) {
            throw new IllegalArgumentException("Nonsense args");
        }
        return c(n, r, cache);
    }

    /**
     * Recursive helper for combi.
     */
    private static long c(int n, int r, long[][] cache) {
        if (r == 0 || r == n) {
            return cache[n][r] = 1;
        } else if (cache[n][r] != 0) {
            return cache[n][r];
        } else {
            cache[n][r] = c(n-1, r-1, cache) + c(n-1, r, cache);
            if (cache[n][r] < 0) {
                throw new RuntimeException("Woops too big");
            }
            return cache[n][r];
        }
    }

    /**
     * Prints out a few example invocations.
     */
    public static void main(String[] args) {
        String[] data = ("0,0,3,1,4,4,5,2,10,0,10,10,10,4,9,7,70,8,295,100," +
                "34,88,-2,7,9,-1,90,0,90,1,90,2,90,3,90,8,90,24").split(",");
        for (int i = 0; i < data.length; i += 2) {
            int n = Integer.valueOf(data[i]);
            int r = Integer.valueOf(data[i + 1]);
            System.out.printf("C(%d,%d) = ", n, r);
            try {
                System.out.println(combi(n, r));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
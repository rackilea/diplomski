static int[] collatzCounts = new int[100];
static final int NO_COUNT = -1;
static {
    Arrays.fill(collatzCounts, NO_COUNT);
    collatzCounts{1] = 0; // Define collatz(1) = 0 (1, 4, 2, 1, ...) 
}

public static void main(String[] args) {
    for (int n = 2; n < 120; n++) {
        int steps = countCollatz(n);
        System.out.println(n + ": " + steps);
    }
}

public static int countCollatz(int n) {
    IntFunction f = k ->
            k % 2 == 0
                ? 1 + countCollatz(k / 2)
                : 1 + countCollatz(3 * k + 1);
                //: 2  + countCollatz((3 * k + 1) /  2);

    //if (n == 1) {
    //    return 0;
    //}
    if (n < collatzCounts.length) {
        if (collatzCounts[n] == NO_COUNT) {
            collatzCounts[n] = f.apply(n);
        }
        return collatzCounts[n];
    } else {
        return f.apply(n);
    }
}
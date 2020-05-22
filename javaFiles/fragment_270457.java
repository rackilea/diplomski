public static class ArithmeticNumberGenerator implements NumberGenerator {

    private final int init; // first term in the sequence
    private final int diff; // common difference
    /**
     * Constructs an arithmetic number generator with given start value init
     * and common difference diff
     * 
     * @param init
     *            start value
     * @param diff
     *            common difference
     * @throws IllegalArgumentException
     *             if any of the input arguments is illegal
     */
    public ArithmeticNumberGenerator(int init, int diff) throws IllegalArgumentException {
        if (init < 0 || diff < 0)
            throw new IllegalArgumentException("Cannot use negative numbers.");
        else {
            this.init = init;
            this.diff = diff;
        }
    }

    @Override
    public int generateNumber(int n) {
        // Time Complexity: O(?)
        // This method generates the number of index n
        // in an arithmetic sequence recursively

        if (n == 0)
            return init;
        else {
            ArithmeticNumberGenerator g = new ArithmeticNumberGenerator(init+diff, diff);
            return g.generateNumber(n - 1);
        }
    }
}
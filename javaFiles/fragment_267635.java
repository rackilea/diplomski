/*
 * moved the flipping into a method; allow it to build the
 *  results rather than immediately outputting them
*/
private static StringBuilder doFlips(int numberOfFlips, Random rng)
{
    long[] runLength = new long[numberOfFlips];
    boolean theCoin;
    boolean tempVal = false;

    int run = 1;
    int totalNumberOfRuns = 0;

    // Here we will collect the output; use better name in production
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < numberOfFlips; i++) {
        theCoin = rng.nextBoolean(); // As requested, I used the nextBoolean
                                     // expression.
        if (theCoin != tempVal) {
            if (i > 0) {
                sb.append(run);
                sb.append(" ");
            }
            runLength[run - 1]++;
            totalNumberOfRuns++;
            run = 1;
        }
        else {
            run++;
        }
        if (theCoin) {
            sb.append("H");
            tempVal = true;
        }
        else {
            sb.append("T");
            tempVal = false;
        }
    }

    return sb;
}
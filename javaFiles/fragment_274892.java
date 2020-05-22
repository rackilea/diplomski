public static int solve(
    final int[] tileSnowDepths,           // tileSnowDepths[0] is f_1
    final int[] bootAllowedDepths,        // bootAllowedDepths[0] is s_1
    final int[] bootAllowedTilesPerStep   // bootAllowedTilesPerStep[0] is d_1
) {
    final int numTiles = tileSnowDepths.length;
    final int numBoots = bootAllowedDepths.length;
    assert numBoots == bootAllowedTilesPerStep.length;

    int maxReachableTileNum = 1; // can reach tile #1 even without boots

    for (int bootNum = 1; bootNum <= numBoots; ++bootNum) {
        final int allowedDepth = bootAllowedDepths[bootNum-1];
        final int allowedTilesPerStep = bootAllowedTilesPerStep[bootNum-1];

        // Find the starting-point for this boot -- ideally the last tile
        // reachable so far, but may need to "backtrack" if that tile is too
        // deep; see explanation above of why it's safe to assume that we
        // can backtrack to the latest not-too-deep tile:

        int reachableTileNum = maxReachableTileNum;
        while (tileSnowDepths[reachableTileNum-1] > allowedDepth) {
            --reachableTileNum;
        }

        // Now see how far we can go, updating both maxReachableTileNum and
        // reachableTileNum when we successfully reach new tiles:

        for (int tileNumToTry = maxReachableTileNum + 1;
             tileNumToTry <= numTiles
                 && tileNumToTry <= reachableTileNum + allowedTilesPerStep;
             ++tileNumToTry
        ) {
            if (tileSnowDepths[tileNumToTry-1] <= allowedDepth) {
                maxReachableTileNum = reachableTileNum = tileNumToTry;
            }
        }

        // If we've made it to the last tile, then yay, we're done:

        if (maxReachableTileNum == numTiles) {
            return bootNum - 1; // had to discard this many boots to get here
        }
    }

    throw new IllegalArgumentException("Couldn't reach last tile with any boot");
}
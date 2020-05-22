public int[] computeGuess(int[] combo, int[] guess) {
    int[] result = new int[4];

    Arrays.fill(result, 5);  // incorrect values for all!

    boolean[] exactMatches = new boolean[4];  // all initially set to false
    boolean[] misplaced    = new boolean[4];

    for (int i = 0; i < 4; i++) {
        if (combo[i] == guess[i]) {
            exactMatches[i] = true;
            misplaced[i] = false;  // make sure we don't use this as misplaced
        } else {
            for (int j = 0; j < 4; j++) {
                if (i != j && combo[i] == guess[j] && !exactMatches[j] && !misplaced[j]) {
                    misplaced[j] = true;
                    break;
                }
            }   
        }
    }

    int i = 0;
    for (boolean b : exactMatches) {
        if (b) {
            result[i++] = 6;
        }
    }
    for (boolean b : misplaced) {
        if (b) {
            result[i++] = 7;
        }
    }

    return result;
}
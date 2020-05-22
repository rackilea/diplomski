public static String[][] generateCombinations(String[]... arrays) {
    if (arrays.length == 0) {
        return new String[][]{{}};
    }
    int num = 1;
    for (int i = 0; i < arrays.length; i++) {
        num *= arrays[i].length;
    }

    String[][] result = new String[num][arrays.length];

    // array containing the indices of the Strings
    int[] combination = new int[arrays.length];

    for (int i = 0; i < num; i++) {
        String[] comb = result[i];
        // fill array
        for (int j = 0; j < arrays.length; j++) {
            comb[j] = arrays[j][combination[j]];
        }

        // generate next combination
        for (int j = arrays.length-1; j >= 0; j--) {
            int n = ++combination[j];
            if (n >= arrays[j].length) {
                // "digit" exceeded valid range -> back to 0 and continue incrementing
                combination[j] = 0;
            } else {
                // "digit" still in valid range -> stop
                break;
            }
        }
    }
    return result;
}
public static String[][] removeNA(String[][] str, int varNumber) {
    String[][] na2Arr = new String[str.length][varNumber];
    // iterate over columns in str
    int columnsCopied = 0;
    for (int col = 0; col < varNumber; col++) {
        if (! columnContainsNa(col, str)) {
            // copy column to result
            for (int row = 0; row < str.length; row++) {
                na2Arr[row][columnsCopied] = str[row][col];
            }
            columnsCopied++;
        }
    }
    if (columnsCopied < varNumber) {
        // shorten each inner array to the actual number of columns (leave out if you don’t want this)
        for (int row = 0; row < str.length; row++) {
            na2Arr[row] = Arrays.copyOf(na2Arr[row], columnsCopied);
        }
    }
    return na2Arr;
}

private static boolean columnContainsNa(int col, String[][] str) {
    String deleteMe = "NA";
    for (int row = 0; row < str.length; row++) {
        if (str[row][col].equals(deleteMe)) {
            return true;
        }
    }
    return false;
}
public static boolean equals(int[][] one, int[][] two) {
    if (one == null || two == null || one.length != two.length)
        return false;

    for (int row = 0; row < one.length; row++) {
        if (one[row].length != two[row].length)
            return false;

        for (int col = 0; col < one[row].length; col++)
            if (one[row][col] != two[row][col])
                return false;
    }

    return true;
}
public int calculateLevenshteinDistance(String first, String second) {

    char[] s = first.toCharArray();
    char[] t = second.toCharArray();
    int substitutionCost = 0;

    int m = first.length();
    int n = second.length();

    int[][] array = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
        array[i][0] = i;
    }

    for (int j = 1; j <= n; j++) {

        array[0][j] = j;
    }

    for (int j = 1; j <= n; j++) {
        for (int i = 1; i <= m; i++) {
            if (s[i - 1] == t[j - 1]) {
                substitutionCost = 0;
            } else {
                substitutionCost = 1;
            }

            int deletion = array[i - 1][j] + 1;
            int insertion = array[i][j - 1] + 1;
            int substitution = array[i - 1][j - 1] + substitutionCost;
            int cost = Math.min(
                    deletion,
                    Math.min(
                            insertion,
                            substitution));
            array[i][j] = cost;
        }
    }

    return array[m][n];
}
public static Set<int[][]> chooseFrom(List<int[]> choices, int choose) {
    Set<int[][]> results = new HashSet<int[][]>();
    if (choose == 1) {
        for (int[] choice : choices)
            results.add(new int[][] { choice });
    } else {
        for (int[] choice : choices) {
            for (int[][] submatrix : chooseFrom(choices, choose - 1)) {
                int[][] matrix = new int[choose][];
                matrix[0] = choice;
                for (int r = 1; r < choose; r++)
                    matrix[r] = submatrix[r-1];
                results.add(matrix);
            }
        }
    }

    return results;
}

public static Set<int[][]> matrices(int M, int N) {
    List<int[]> possibleRows = new ArrayList<int[]>();

    for (int i = 0; i < N; i++) {
        int[] row = new int[N];
        row[i] = 1;
        possibleRows.add(row);
    }

    return chooseFrom(possibleRows, M);
}
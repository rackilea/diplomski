private void rotate(List<List<Integer>> matrix, int m, int n) {
    for (List<Integer> row : matrix) {
        Collections.rotate(row, m);
    }
    Collections.rotate(matrix, n);
}

public void test() {
    int[][] m = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    List<List<Integer>> matrix = new ArrayList<>();
    for (int[] r : m) {
        List<Integer> row = new ArrayList<>();
        for (int v : r) {
            row.add(v);
        }
        matrix.add(row);
    }
    System.out.println("Before: " + matrix);
    rotate(matrix, 1, 2);
    System.out.println("After: " + matrix);
}
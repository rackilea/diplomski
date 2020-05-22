public static void main (String[] args) throws Exception {
    int[][] matrix = new int[3][];
    matrix[0] = new int[] {1, 2, 2};
    matrix[1] = new int[] {2, 2, 3};
    matrix[2] = new int[] {0, 1, 2};

    int result = 1;
    for (int i=0; i<matrix.length; i++) {
        result *= matrix[i][i];
    }
    System.out.println(result);
}
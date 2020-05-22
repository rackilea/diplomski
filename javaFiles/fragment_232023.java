int matrixElementsSum(int[][] matrix) {
    return IntStream.range(0, matrix.length)
            .map(i -> IntStream.range(0, matrix[0].length)
                    .map(j -> IntStream.range(0, i)
                            .anyMatch(k -> matrix[k][j] == 0)
                            ? 0 : matrix[i][j] )
                    .sum())
            .sum();
}
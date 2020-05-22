public static double computePyramidWeights(double [][] weights, int row, int col){
    if (row < 0 || col < 0 || col >= weights[row].length) {
        return 0.0;
    }
    return weights[row][col]
            + 0.5 * computePyramidWeights(weights, row-1, col)
            + 0.5 * computePyramidWeights(weights, row-1, col-1);
}
public static void main(String[] args) {
    double[][] data = { { 1, 2, 3 }, { 4, 5, 6 } };

    RealMatrix matrix = MatrixUtils.createRealMatrix(data);

    RealMatrix transpose = matrix.transpose();
}
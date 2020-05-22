public static ArrayList<Matrix> generateMatrices(int num, int size) {
    ArrayList<Matrix> matrices = new ArrayList<Matrix>();

    for(int i = 0; i < num; i++) {
        double[][] matrix = new double[size][size];
        //populate matrix with random numbers
        matrices.add(new Matrix(matrix));
    }
    return matrices;
}
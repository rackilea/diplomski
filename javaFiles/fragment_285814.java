public static void main(String[] args) throws IOException {

    int[][] testData = new int[10][10];

    for (int i = 0; i < testData.length; i++) 
        for (int j = 0; j < testData[i].length; j++)
            testData[i][j] = 100 + i + j;

    Matrix full = new Matrix(testData);

    System.out.println("Full test matrix:");
    System.out.println(full);

    System.out.println();

    System.out.println("Part of the matrix:");
    System.out.println(full.getSubMatrix(3, 3, 3, 3));

}
public static double[][] matrix(String filename, int size1, int size2) throws Exception {
    double[][] matrix = new double[size1][size2];;

    BufferedReader buffer = new BufferedReader(new FileReader(filename));

    String line;
    int row = 0;

    while ((line = buffer.readLine()) != null) {
        String[] vals = line.trim().split("\\s+");


        for (int col = 0; col < size2; col++) {
            matrix[row][col] = Double.parseDouble(vals[col]);
        }

        row++;
    }
    buffer.close();
    return matrix;
}
int row = getRowDim(x, y);
int col = getColDim(x, y);

double[][] matrix; //length of array cannot be guaranteed before reading the result set.

try {
    conn = dataSource.getConnection();
} catch (SQLException e1) {
    e1.printStackTrace();
}

List<double[]> matrixList = new ArrayList<>(); //rather use an array list to avoid unexpected index errors

try {
    PreparedStatement p = conn.prepareStatement(getMatrix);
    p.setInt(1, x);
    p.setInt(2, y);
    ResultSet r = p.executeQuery();

    while(r.next())
    {
        String px = r.getString("prices");
        String[] intermediateArray  = px.split(",", -1);

        double[] parsed = new double[intermediateArray.length];
        for (int i = 0; i < intermediateArray.length; i++) {

            //use Double.parseDouble(String) to avoid unnecessary boxing/unboxing
            parsed[i] = Double.parseDouble(intermediateArray[i]);
        }

        matrixList.add(parsed);
    }

    matrix = new double[matrixList.size()][];
    conn.close();

    int index = 0;
    for(double[] currentRow: matrixList) {
        matrix[index++] = currentRow;
    }

    return matrix;
} catch (SQLException e) {
    logger.error("***** SQL EXCEPTION *****");
    e.printStackTrace();
    return new double[0][0];
}
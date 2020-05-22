private ArrayList cosineSimilarity(int rowIndex, Matrix D) {
    ArrayList<Double> similarRows = new ArrayList<>();

    for(int row = 0; row < D.getRowDimension(); row++){
        double dotProduct = 0.0, firstNorm = 0.0, secondNorm = 0.0;
        for (int column = 0; column < D.getColumnDimension(); column++) {
        dotProduct += (D.get(rowIndex, column) * D.get(row, column));
        firstNorm += pow(D.get(rowIndex, column),2);
        secondNorm += pow(D.get(row, column), 2);
       // Matrix f = D.getMatrix(row, column);
        }
        double cosinSimilarity = (dotProduct / (sqrt(firstNorm) * sqrt(secondNorm)));
        similarRows.add(row, cosinSimilarity);
    }
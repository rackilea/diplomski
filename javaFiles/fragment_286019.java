void removeRow(ArrayList<ArrayList<Double>> matrix, int rowIndexToRemove) {
    matrix.remove(rowIndexToRemove);
}

void removeColumn(ArrayList<ArrayList<Double>> matrix, int coulmnIndexToRemove) {
    for (ArrayList<Double> row : matrix) {
        row.remove(coulmnIndexToRemove);
    }
}

void addRow(ArrayList<ArrayList<Double>> matrix, int rowIndexWhereInsert, ArrayList<Double> newRow) {
    matrix.add(rowIndexWhereInsert, newRow);
}

void addColumn(ArrayList<ArrayList<Double>> matrix, int columnIndexWhereInsert, ArrayList<Double> newColumn) {
    for (int k = 0; k < matrix.size(); k++) {
        ArrayList<Double> row = matrix.get(k);
        row.add(columnIndexWhereInsert, newColumn.get(k));
    }        
}
ArrayList<ArrayList<Boolean>> matrix = new ArrayList<>(nRows);
for(int r = 0 ; r < nRows ; r++) {
    ArrayList<Boolean> row = new ArrayList<>(nCols);
    for(int c = 0 ; c < nCols ; c++) {
        row.add(false);
    }
    matrix.add(row);
}
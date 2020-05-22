ArrayList<String> keys = new ArrayList<String>(res.keySet());
int rowSize = keys.size();
int colSize = res.get(keys.get(0)).size();
double [][] multi = new double[rowSize][colSize];
for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
    String key = keys.get(rowIndex);
    List<Integer> row = res.get(key);
    for (int colIndex = 0; colIndex < colSize; colIndex++) {
        multi[rowIndex][colIndex] = row.get(colIndex);
    }
}
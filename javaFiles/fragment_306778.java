double[][] test = { {100}, {200}, {300}, {400}, {500}, {600}, {700}, {800}, {900}, {1000} };
int[][] removeRow = { {0}, {1}, {3}, {4} };
int j = 0;
List<double[]> rowsToKeep = new ArrayList<>(test.length);
for (int i = 0; i < test.length; i++) {
    if (j < removeRow.length && removeRow[j][0] == i) {
        j++;
    } else {
        double[] row = test[i];
        rowsToKeep.add(row);
    }
}
test = new double[rowsToKeep.size()][];
for (int i = 0; i < rowsToKeep.size(); i++) {
    test[i] = rowsToKeep.get(i);
}
System.out.println(Arrays.deepToString(test));
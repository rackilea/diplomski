String[] columns = {"col1" , "col2"};
String[] y = { "TEST", "BUG" ,"ENH"};
int[][] values = new int[y.length][columns.length]; // 2D array

for (int j = 0; j < y.length; j++) {
  for (k = 0; k < columns.length; k++) {    
    values[j][k] = table.getVal(j, columns[k]);
  }
}
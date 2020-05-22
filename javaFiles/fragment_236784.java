int[][] table = new int[][]{{1,2,0},{2,0,1},{1,0,2}};
int[][] result = new int[table.length][table.length];
for (int row = 0; row<result.length;row++){
  Arrays.fill(result[row], 0);
}

// iterating through multi dimensional arrays it is easier to start
// with dimension 0
for (int row = 0; row<table.length;row++){
  for (int col =0; col< table[row].length ; col++){
    // the row in the result table equals the value of the cell.
    int index = table[row][col];
    result[index][col]++;
  }
}

System.out.println(Arrays.deepToString(result));
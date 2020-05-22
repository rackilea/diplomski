public static void main(String[] args) {

    int[][] array2 = {
        {1, 2, 3, 4},
        {1, 2, 20, 4},
        {1, 20, 2, 4},
        {1, 2, 3, 4}
    };

    // find the maximum value and store its position:
    // It's List instead of a single value as multiple 
    // rows and columns can hold the same maximum value
    List<Integer> rowsWithMaxValue = new ArrayList<>();
    List<Integer> colsWithMaxValue = new ArrayList<>();
    int maxValue = Integer.MIN_VALUE;

    // First matrix-scan to fetch the maximum value and the
    // row(s) and column(s) to set the value at 0
    for (int row = 0; row < array2.length; row++) {
        for (int col = 0; col < array2[row].length; col++) {

            // get the current value
            int value = array2[row][col];

            // found a new maximum or an existing one?
            if (value > maxValue) {
                // this is a new maximum value, we can reset
                // the list as the previous rows and columns
                // are not relevant anymore
                maxValue = value;
                rowsWithMaxValue = new ArrayList<>();
                colsWithMaxValue = new ArrayList<>();
                rowsWithMaxValue.add(row);
                colsWithMaxValue.add(col);
            } else if (value == maxValue) {
                // The same value (like 20) is found again
                // so multiple rows and columns will have 
                // their value set at 0
                rowsWithMaxValue.add(row);
                colsWithMaxValue.add(col);
            }
        }
    }

    // Second matrix-scan for updating the values and printing
    for (int row = 0; row < array2.length; row++) {
        for (int col = 0; col < array2[row].length; col++) {
            // is it in a forbidden row? If yes, set the value
            // at zero. One of the condition (row or column) is
            // enough to have its value set at 0
            if (rowsWithMaxValue.contains(row) || colsWithMaxValue.contains(col)) {
                array2[row][col] = 0;
            }

            // Simply print the value
            System.out.print(array2[row][col] + " ");
        }
        System.out.println();
    }
}
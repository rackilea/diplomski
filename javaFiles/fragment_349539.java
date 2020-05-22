int[][] square = new int[size][size];
//
// ... Setup values in square ...
//
for (int row = 0; row < size; row++) {
    boolean rowAlike = true;
    for (int col = 1; col < size; col++) {
        if (square[row][col - 1] != square[row][col]) {
            rowAlike = false;
            break;
        }
    }
    if (rowAlike) {
        System.out.printf("All digits are the same in row %d%n",
                row + 1);
    }
}
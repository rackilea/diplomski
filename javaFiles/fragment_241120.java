// set up your matrix, any size and shape (MxN) is fine, but jagged arrays will break
int[][] matrix = {{0,0,0},{0,0,0},{0,0,0}};

// number is the value we will put in each position of the matrix
int number = 1;

// iterate while number is less than or equal to the total number of positions
// in the matrix. So, for a 3x3 matrix, 9. (this is why the code won't work for
// jagged arrays)
for (int i = 0; number <= matrix.length * matrix[0].length; i++) {
    // start each diagonal at the top row and from the right
    int row = 0;
    int col = i;

    do {
        // make sure row and length are within the bounds of the matrix
        if (row < matrix.length && col < matrix[row].length) {
            matrix[row][col] = number;
            number++;
        }

        // we decrement col while incrementing row in order to traverse down and left
        row++;
        col--;
    } while (row >= 0);
}
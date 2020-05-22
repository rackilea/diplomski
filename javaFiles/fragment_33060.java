int rows = 3;
int cols = 3;
for (int row = 0; row < rows; row++) {
    for (int col = 0; col < cols; col++) {
        int pieces = rows * cols - (row * 3 + col);
        String count = Integer.toString(pieces);
        // ...
    }
}
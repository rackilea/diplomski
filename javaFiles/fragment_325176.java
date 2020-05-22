int sum = 0;
for (int row = 0; row < n; row++) {
    for (int col = 0; col < m; col++) {
        // count all rectangles with top left corner at (row,col)
        int upperLimit = m; // this number sets the max width that rectangles with greater
                            // height can have (depends on the 1s in the rows above)
        for (int r = row; r < n && matrix[r][col] == 1; r++) {
            int c = col;
            for (; c < upperLimit && matrix[r][c] == 1; c++)
                sum++;
            upperLimit = c;
        }
    }
}
int[][] field;    
int max(int r, int c) {
    //Base case
    if (r == 0 && c == 0) {
        return field[r][c];
    }
    //Assuming a positive number of strawberries in each plot, otherwise this needs
    //to be negative infinity
    int maxTop = -1, maxLeft = -1;
    //We can't come from the top if we're in the top row
    if (r != 0) {
        maxTop = field[r-1][c];
    }
    //Similarly, we can't come from the left if we're in the left column
    if (c != 0) {
        maxLeft = field[r][c-1];
    }
    //Take whichever gives you more and return..
    return Math.max(maxTop, maxLeft) + field[r][c];
}
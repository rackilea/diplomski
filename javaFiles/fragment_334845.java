if (row <= -1 || row == rows || col <= -1 || col == cols) {
        return false;
}
else {
    return lifeBoard[row][col];
}
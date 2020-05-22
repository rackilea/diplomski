public boolean isValid(int r, int c) {
    if (r < 0 || c < 0 || r >= size || c >= size || board[r][c] != 0) {
        return false;
    }
    return true;
}
int idx(int x, int y) {
    return y*widthOfBoard() + x;
}

int x(int idx) {
    return idx % widthOfBoard();
}

int y(int idx) {
    return (idx - x(idx)) / widthOfBoard();
}
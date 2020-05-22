private void generateNeighbor(int toPosition, boolean isRow) {
    Board board = new Board(this.tilesCopy);
    if (isRow)  swapEntries(board.tilesCopy, zeroRow, zeroCol, toPosition, zeroCol);
    else        swapEntries(board.tilesCopy, zeroRow, zeroCol, zeroRow, toPosition);

    neighbors.add(board);
}
private int getNeighbours(LifeBoard board, int row, int col) {
    int neighbours = 0;
    for (int xOffset = -1; xOffset < 2; xOffset++) {
        for (int yOffset = -1; yOffset < 2; yOffset++) {
            if ((xOffset != 0 || yOffset != 0)
                  && board.get(row + yOffset, col + xOffset)) {
                neighbours++;
            }
        }
    }
    return neighbours;
}
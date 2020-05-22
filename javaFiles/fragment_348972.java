public PieceType getElement(int i, int j) {
    if ((i < 0) || (i >= rows) ||
        (j < 0) || (j >= columns)) {
        return null;
    }

    return table[i][j];
}
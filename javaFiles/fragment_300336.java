private static boolean isDiagonalClear(int row, int col) {
    int total = 0;

    do {
        if (board[row--][col++] == 'Q')
            total++;
    } while (total <= 1 && row >= 0 && col < 8);

    return total <= 1;
}

public static boolean diagonalsClear() {
    for (int row = 0; row < 7; row++)
        if (!isDiagonalClear(row, 0))
            return false;

    for (int col = 0; col < 8; col++)
        if (!isDiagonalClear(7, col))
            return false;

    return true;
}
if (d2 > d1) {
    startRow = startRow ^ endRow;
    endRow = startRow ^ endRow;
    startRow = startRow ^ endRow;

    startCol = startCol ^ endCol;
    endCol = startCol ^ endCol;
    startCol = startCol ^ endCol;
}
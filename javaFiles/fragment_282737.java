void solveSquare(currentLayout, row, column) {
    if row > maxRows
        print(layout);
        return;

    if column > maxColumns
        solveSquare(currentLayout, row + 1, 0)
        return;

    foreach digit d in [1, 2, 3, 4, 5, 6, 7, 8, 9] :
        if isValidDigitAtSquare(currentLayout, row, column)
            temp = currentLayout[row][column];
            currentLayout[row][column] = d;
            solveSquare(currentLayout, row, column + 1);
            currentLayout[row][column] = temp;
}
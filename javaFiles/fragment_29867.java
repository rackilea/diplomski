boolean isMagicSquare(int[][] intArray) {
    // check diagonals
    int sum = diagonalSumLeftToRight(intArray);
    if (sum != diagonalSumRightToLeft(intArray)) {
        return false;
    }

    // check rows and columns
    for (int i = 0; i < 4; i++) {
        if (sum != sumRow(intArray, i) || sum != sumColumn(intArray, i)) {
            return false;
        }
    }

    return true;
}

// ...
if (isMagicSquare(intArray)) {
    // ...
}
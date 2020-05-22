for (int i = 0; i < 8; i++) {
    for (int j = 0; j < 8; j++) {
        if (i == rowValueFinal && j == columnValueFinal) {
            chessBoardArray[i][j] = 1;
        } else {
            chessBoardArray[i][j] = 0;
        }
    }
}
// Copy the sudoku matrix
private Cella[][] createCopy() {
    Cella[][] toReturn = new Cella[9][9];
    for (int i = 0; i < 9; i++) {
        // !!ERROR!!
        System.arraycopy(sudoku[i], 0, toReturn[i], 0, 9);
    }
    return toReturn;
}
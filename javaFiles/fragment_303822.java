private Cella[][] createCopy() {
    Cella[][] toReturn = new Cella[9][9];
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            toReturn[i][j] = new Cella(sudoku[i][j].getCurrent());
        }
    }
    return toReturn;
}
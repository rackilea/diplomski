for (int i = 0; i < 9; i++) {
    for (int j = 0; j < 9; j++) {
        sudoku[i][j]= new ArrayList<Integer>();
        for (int k = 1; k < 10; ) {
            sudoku[i][j].add(k);
        }
    }
}
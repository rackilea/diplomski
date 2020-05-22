public static void backtracking(int row, int col) {
    if (row > 8) {
        System.out.println("Solution Found!!");
        printSudoku();
        System.exit(0); //exiting after solution is found
    }
    if (m[row][col] != 0) {
        next(row, col);
    } else {
        for (int i = 1; i <= 9; i++) //replaced i < n with i<=9
            if (row(row, i) && col(col, i) && region(row, col, i)) { //calling region method too
                m[row][col] = i;
                next(row, col);
            }
        m[row][col] = 0;
    }

}
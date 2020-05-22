public static boolean isHorizontalSolved(char[][] spelplan) {
        boolean solved = false;
        for (int y = 1; y < spelplan.length; y++) {
            if ((spelplan[y][1] == spelplan[y][2]) && (spelplan[y][1] == spelplan[y][3]) && (spelplan[y][1] != ' ')) {
                solved = true;
            }
        }
        return solved;
    }

    public static boolean isVerticalSolved(char[][] spelplan) {
        boolean solved = false;
        for (int y = 1; y < spelplan.length; y++) {
            if ((spelplan[1][y] == spelplan[2][y]) && (spelplan[1][y] == spelplan[3][y]) && (spelplan[1][y] != ' ')) {
                solved = true;
            }
        }
        return solved;
    }

    public static boolean isDiagonalSolved(char[][] spelplan) {
        boolean solved = false;
        if ((spelplan[1][1] == spelplan[2][2]) && (spelplan[1][1] == spelplan[3][3]) && (spelplan[1][1] != ' ')) {
                solved = true;
            }

        if ((spelplan[1][3] == spelplan[2][2]) && (spelplan[1][3] == spelplan[3][1]) && (spelplan[1][3] != ' ')) {
                solved = true;
            }

        return solved;
    }
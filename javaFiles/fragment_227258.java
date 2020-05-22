public static Boolean getWinner(Boolean[][] grid) {
    if (grid == null)
        return null;
    int size = grid.length;
    if (size == 0)
        return null;
    if (size == 1 && (grid[0][0] != null)) {
        return grid[0][0];
    }
    boolean flag = true;
    // checks horizontal
    for (int index = 0; index <= size - 1; index++) {
        flag = true;
        for (int i = 1; i <= size - 1; i++) {
            if (grid[index][i] != grid[index][i - 1]) {
                flag = false;
                break;
            }
        }
        if (flag)
            return grid[index][0];
    }
    // checks vertical
    for (int index = 0; index <= size - 1; index++) {
        flag = true;
        for (int i = 1; i <= size - 1; i++) {
            if (grid[i][index] != grid[i - 1][index]) {
                flag = false;
                break;
            }
        }
        if (flag)
            return grid[0][index];
    }
    // checks diagonal
    flag = true;
    for (int index = 1; index <= size - 1; index++) {
        if (grid[index][index] != grid[index - 1][index - 1]) {
            flag = false;
            break;
        }
    }
    if (flag)
        return grid[0][0];
    flag = true;
    for (int index = 1; index <= size - 1; index++) {
        if (grid[size - index - 1][index] != grid[size - index][index - 1]) {
            flag = false;
            break;
        }
    }
    if (flag)
        return grid[size - 1][0];
    return null;
}
//below makes difference with one test case
for (int i = 0; i < path.length; i++) {
    for (int j = 0; j < path[i].length; j++) {
        if (i == j)
            path[i][j] = 0;
    }
}
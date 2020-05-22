public Integer[][] right(Integer[][] M) {
    Integer[][] newM = new Integer[4][4];

    // modify newM in your algo instead of M
    // Showing only the first bloc
    for (int k = 0; k < 4; k++)
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 3; j++) {
                if (M[i][j] != 0 && M[i][j + 1] == 0) {
                    newM[i][j + 1] = M[i][j + 1] + M[i][j];
                    newM[i][j] = 0;
                    new_tile = true;
                }
            }
    //...
    return newM;
}
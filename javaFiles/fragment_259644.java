stMax[i] = 0;
    for (int j = 0; j < S; j++) {
        if (st[i][j] > stMax[i]) {
            stMax[i] = st[i][j];
        }
    }
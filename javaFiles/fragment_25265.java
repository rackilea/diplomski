public void transpose(){

    int tmp1, tmp2;
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            tmp1 = matice[i][j];
            tmp2 = matice[j][i];
            matice[i][j] = tmp2;
            matice[j][i] = tmp1;
        }
    }
for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
        if (j < m - 1)
            System.out.print(mat[i][j] + " ");
        else
            System.out.println(mat[i][j]);
    }
}
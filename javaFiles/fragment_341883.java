for (int j = 0; j < u.length; j++) {
    for (int i = 0; i < v.length; i++) {
        int tracker = u[j] == v[i] ? 0 : 1;
        int temp = Math.min(d[i][j + 1] + 1, d[i + 1][j] + 1);
        d[i + 1][j + 1] = Math.min(temp, d[i][j] + tracker);
    }
}
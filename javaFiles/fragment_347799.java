void rotate(int x, int y, int N) {
    for (int i = 0; i < (N + 1) / 2; i++) {
        for (int j = 0; j < N / 2; j++) {
            int temp = M[x + i][y + j];
            M[x + i][y + j] = M[x + N - 1 - j][y + i];
            M[x + N - 1 - j][y + i] = M[x + N - 1 - i][y + N - 1 - j];
            M[x + N - 1 - i][y + N - 1 - j] = M[x + j][y + N - 1 - i];
            M[x + j][y + N - 1 - i] = temp;
        }
    }
}
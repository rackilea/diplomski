int[] pattern = {0, 1, 0, 0, 1, 1, 1};
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        long x = (long) i * j * i * j;
        if (x < 2) {
            uniMatrix[i][j] = (int) x;
        } else {
            uniMatrix[i][j] = pattern[(int)((x - 2) % pattern.length)];
        }
    }
}
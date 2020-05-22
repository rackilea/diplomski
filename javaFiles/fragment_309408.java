static int[] records(int[] score) {
    int m = 0, n = 0, max = score[0], min = score[0];
    for (int i = 1; i < score.length; i++) {
        if (score[i] > max) {
            m++;
            max = score[i];
        }
        if (score[i] < min) {
            n++;
            min = score[i];
        }
    }
    return new int[] { n, m, min, max };
}
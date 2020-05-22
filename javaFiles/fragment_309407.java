static int[] records(int[] score) {
    int max = score[0], min = score[0];
    for (int i = 1; i < score.length; i++) {
        max = Integer.max(max, score[i]);
        min = Integer.min(min, score[i]);
    }
    return new int[] { min, max };
}
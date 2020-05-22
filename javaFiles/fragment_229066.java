public int[] calculatePercentage(int exam[][]) {
    int[] sums = new int[exam.length];
    for (int i = 0; i < exam.length; i++) {
         for (int j = 0; j < exam[i].length; j++) {
              sums[i] += exam[i][j];
         }
    }
    return sums;
}
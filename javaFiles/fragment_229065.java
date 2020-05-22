public int[] calculatePercentage(int exam[][]) {
    int[] sums = new int[exam.length];
    for (int i = 0; i < exam.length; i++) {
         int sum = 0;
         for (int j = 0; j < exam[i].length; j++) {
              sum += exam[i][j];
         }
         sums[i] = sum;
    }
    return sums;
}
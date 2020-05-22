public static int golf(int holeLength, int[] clubLengths) {
    int[][] dp = int[clubLengths.length()][holeLength+1];
    return golf(holeLength, clubLengths, 0, dp);
}

private static int golf(int holeLength, int[] clubLengths, int ind, int[][] dp) {
    if (holeLength == 0) return 0;
    if (holeLength < 0) return -1;
    if (ind >= clubLengths.length()) return -1;
    if (dp[ind][holeLength] != 0) return dp[ind][holeLength];

    int rec1 = golf(holeLength-clubLengths[ind], clubLengths, ind, dp);
    if (rec1 == -1) rec1 = Integer.MAX_VALUE;
    else rec1++;

    int rec2 = golf(holeLength-clubLengths[ind], clubLengths, ind+1, dp);
    if (rec2 == -1) rec2 == Integer.MAX_VALUE;
    else rec2++;

    int rec3 = golf(holeLength, clubLengths, ind+1, dp);
    if (rec3 == -1) rec3 = Integer.MAX_VALUE;

    int result = Math.min(rec1, rec2);
    result = Math.min(result, rec3);
    if (result == Integer.MAX_VALUE) result = -1;

    dp[ind][holeLength] = result;
    return result;
}
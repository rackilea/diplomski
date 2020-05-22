public class Solution {

    public int longestCommonSubsequence(String A, String B) {
        if(A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }

        int m = A.length();
        int n = B.length();
        int[][] commonSubsequenceLength = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    commonSubsequenceLength[i][j] = commonSubsequenceLength[i - 1][j - 1] + 1;
                } else {
                    commonSubsequenceLength[i][j] = Math.max(commonSubsequenceLength[i][j - 1], commonSubsequenceLength[i - 1][j]);
                }
            }
        }

        return commonSubsequenceLength[m][n];

    }
}
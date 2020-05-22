public class KnapSackEven {
    public static void main(String[] args) {
        int[] weights = new int[] {4, 3, 3, 5, 1, 2, 7, 12};
        int[] values =  new int[] {2, 1, 3, 15, 3, 5, 9, 4};

        int n = weights.length;
        int W = 10;

        int[][] DP_odd = new int[n+1][W+1];
        int[][] DP_even = new int[n+1][W+1];

        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < W+1; j++) {
                DP_even[i][j] = -1;
                DP_odd[i][j] = -1;

                if(i == 0 || j == 0) {
                    DP_odd[i][j] = -1;
                    DP_even[i][j] = 0;
                } else if(j - weights[i-1] >= 0) {
                    if(DP_odd[i-1][j - weights[i-1]] >= 0) {
                        DP_even[i][j] = Math.max(DP_even[i-1][j], DP_odd[i-1][j - weights[i-1]] + values[i-1]);
                    }
                    if(DP_even[i-1][j - weights[i-1]] >= 0) {
                        DP_odd[i][j] = Math.max(DP_odd[i-1][j], DP_even[i-1][j - weights[i-1]] + values[i-1]);
                    }
                }

                if(i > 0) {
                    DP_odd[i][j] = Math.max(DP_odd[i][j], DP_odd[i-1][j]);
                    DP_even[i][j] = Math.max(DP_even[i][j], DP_even[i-1][j]);
                }
            }
        }

        System.out.println("Result: " + DP_even[n][W]);
    }
}
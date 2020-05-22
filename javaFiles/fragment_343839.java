import java.io.*;
import java.util.*;

class Main {

    final static float INF = 1e10f;

    public static void main(String[] args) {
        final int n = 25;
        float[][] dist = new float[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                dist[i][j] = dist[j][i] = random.nextFloat();
        float[][] dp = new float[n][1 << n];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], INF);
        dp[0][1] = 0.0f;
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int lastNode = 0; lastNode < n; lastNode++) {
                if ((mask & (1 << lastNode)) == 0)
                    continue; 
                for (int nextNode = 0; nextNode < n; nextNode++) {
                    if ((mask & (1 << nextNode)) != 0)
                        continue;
                    dp[nextNode][mask | (1 << nextNode)] = Math.min(
                            dp[nextNode][mask | (1 << nextNode)],
                            dp[lastNode][mask] + dist[lastNode][nextNode]);
                }
            }   
        }
        double res = INF;
        for (int lastNode = 0; lastNode < n; lastNode++)
            res = Math.min(res, dist[lastNode][0] + dp[lastNode][(1 << n) - 1]);
        System.out.println(res);
    }
}
/**
 * Finds the longest path between two specified vertices in a specified graph.
 * @param from The start vertex.
 * @param to The end vertex.
 * @param graph The graph represented as an adjacency matrix.
 * @return The length of the longest path between from and to.
 */
public int getLongestPath(int from, int to, boolean[][] graph) {
    int n = graph.length;
    boolean[][] hasPath = new boolean[1 << n][n];
    hasPath[1 << from][from] = true;
    for (int mask = 0; mask < (1 << n); mask++)
        for (int last = 0; last < n; last++)
            for (int curr = 0; curr < n; curr++)
                if (graph[last][curr] && (mask & (1 << curr)) == 0)
                    hasPath[mask | (1 << curr)][curr] |= hasPath[mask][last];
    int result = 0;
    for (int mask = 0; mask < (1 << n); mask++)
        if (hasPath[mask][to])
            result = Math.max(result, Integer.bitCount(mask));
    return result;
}
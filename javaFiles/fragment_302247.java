private static int dijkstras(Graph g, int start) // Added a start point.
    {
    // Dijkstra's Algorithm
    int[] best = new int[g.network.length];
    boolean[] visited = new boolean[g.network.length];
    int max = 10000; // Infinity equivalent.
    for (int i = 0; i < g.network.length; i++)
    {
        best[i] = max;
        visited[i] = false;
    }

    best[start] = start; // Changed the 0 to variable start.

    for(int i = 0; i < g.network.length; i++)
    {
        int min = max;
        int currentNode = 0;
        for (int j = 0; j < g.network.length; j++)
        {
            if (!visited[j] && best[j] < min)
            {
                currentNode = j;
                min = best[j];
            }
        }
        visited[currentNode] = true;
        for (int j = 0; j < g.network.length; j++)
        {
            if (g.network[currentNode][j] < max && best[currentNode] +   g.network[currentNode][j] < best[j])
            {
                best[j] = best[currentNode] + g.network[currentNode][j];
            }
        }
    }
            return best[g.network.length - 2];
}
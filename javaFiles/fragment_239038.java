void DFSUtil(int v,boolean visited[])
{

    visited[v] = true;
    System.out.print(v+" ");


    Iterator<Integer> i = adj[v].listIterator();
    while (i.hasNext())
    {
        int n = i.next();
        if (!visited[n])
            DFSUtil(n, visited);
    }
}


void DFS(int v)
{

    boolean visited[] = new boolean[V];

    // Call the recursive helper function to print DFS traversal
    DFSUtil(v, visited);
}
private static <V> Set<V> findReachable(
    Collection<? extends V> startNodes, Graph<V, ?> graph)
{
    Queue<V> queue = new LinkedList<V>();
    Set<V> visited = new LinkedHashSet<V>();
    queue.addAll(startNodes);
    visited.addAll(startNodes);
    while(!queue.isEmpty()) 
    {
        V v = queue.poll();
        Collection<V> neighbors = graph.getNeighbors(v);
        for (V n : neighbors)
        {
            if (!visited.contains(n))
            {
                queue.offer(n);
                visited.add(n);
            }
        }
    }
    return visited;
}
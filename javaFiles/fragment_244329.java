/**
 *
 * @param nodes The nodes still to be added to our edge list.
 * @param edges The current edge list. This is mutated, so always return a clone!
 */
public static <N> List<Map<N,N>> enumerateEdges(List<N> nodes,Map<N,N> edges){
    if(nodes.isEmpty()) // No more nodes to create edges from, so return our current edge list in a new list.
        return Collections.singletonList(new HashMap<>(edges));


    N start = nodes.get(0); //The start node of our next pair.

    List<Map<N,N>> acc = new LinkedList<>(); //The accumulation of the EdgeLists

    for(int i = 1; i<nodes.size(); ++i){

        N end = nodes.get(i); //The end node of our pair
        edges.put(start,end); //Add this pair to our edge list

        List<N> unused = new ArrayList<>(nodes); // The nodes not used in our edge list.
        unused.remove(i);
        unused.remove(0);

        acc.addAll(enumerateEdges(unused,edges));

        edges.remove(start); //Remove this pair from our edge list.
    }

    return acc;
}
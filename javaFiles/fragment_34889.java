private ArrayList<GraphNode> getDisconnectedSet(ArrayList<GraphNode> allNodes, GraphNode target)
{
    if(!allNodes.contains(target))
        return;

    allNodes.remove(target);

    for(Edge e : edges) // Need to edit to iterate through connected nodes
        getDisconnectedSet(allNodes, e.otherSide);
}
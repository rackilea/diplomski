public List<String> getLeavesDeepX()
{
    final Deque<Node> nodes = new LinkedList<Node>();
    final Collection<String> leaves = new LinkedList<String>();
    //final Collection<String> leaves = new LinkedHashSet<String>(); -- use for removing dupes
    nodes.add(this);
    do
    {
        final Node current = nodes.pop();
        leaves.addAll(current.getLeaves());
        nodes.addAll(current.getTreeNodes());
    }
    while(nodes.isEmpty() == false);

    final ArrayList<String> result = new ArrayList<String>(leaves);
    Collections.sort(result);
    return result;
}
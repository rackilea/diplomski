public bool detectLoop(LinkedList<EntityNode> list)
{
    Set<EntityNode> nodeSet = new HashSet<EntityNode>();
    EntityNode curNode = list.getHead();
    boolean loopDetected = false;

    if(curNode != null)
    {
        while(curNode.getNextNode() != null && !loopDetected)
        {
            cureNode = curNode.getNextNode();
            loopDetected = !nodeSet.add(curNode);
        }
    }

    return loopDetected;
}
public String createNodeListFor( MyNode endNode, ArrayList<MyNodes> nodes )
{
    String result = "";
    // Again, this assumes the nodes are sorted by 'lft'
    for ( int i = 0; i < nodes.size(); i++ )
    {
        MyNodes current = nodes.elementAt(i);
        if ( current.id == endNode.id )
            continue; // skip self test
        if ( current.lft < endNode.lft && current.rgt > endNode.rgt )
        {
            if ( result == null )
                result = current.value;
            else
                result += "->" + current.value;
            continue;
        }
        if ( current.lft < endNode.lft && current.rgt < endNode.rgt )
        {
            return null; // this node is not an end node
        }
        if ( current.lft > endNode.lft )
        {
            break; // assuming the list is correctly sorted, we don't need to check any more nodes
        }
    }
    return result;
}
public void markNodes(Node startnode)
{
    colour(startnode);//<-- this highlightes the Tile
    if(left != null && startnode.isconnected(neighbourleft))
        markNodes(startnode);

    if(right != null && startnode.isconnected(neighbourright))
        markNodes(startnode);

    if(up != null && startnode.isconnected(neighbourup))
        markNodes(startnode);

    if(down != startnode.isconnected(neighbourdown))
        markNodes(startnode);
}
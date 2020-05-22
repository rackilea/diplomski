// returns the number of nodes in the list
public int Count(){ return CountHelper( head ); }

// helper recursive function
// returns the number of nodes in the list after and including "node".
// call with head of the list to get the count of all nodes.
private int CountHelper( Node node )
{
    if( node == null )
       return 0;
    else
       return 1 + CountHelper( node.getNext() );
}
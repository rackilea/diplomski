private  Node createBalancedTree(int arr[], int start, int end){

    if ( end < start ) return null;        // empty array -> empty tree

    int mid = start + (end - start) / 2;   // avoid overflow

    // create a tip node
    Node node = new Node( arr[mid] );

    // convert remaining subarrays (if any) into subtrees
    node.leftChild = createBalancedTree( arr, start, mid - 1 );
    node.rightChild = createBalancedTree( arr, mid + 1, end );

    return node;
} 

public void createBalancedTree( int array[] ) {
    // convert the array into a tree and plant it in this
    root = createBalancedTree( array, 0, array.length - 1 );
}
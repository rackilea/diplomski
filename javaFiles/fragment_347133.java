public LinkedList<AnyType> traverse (TheNode<AnyType> node,LinkedList<AnyType> theList){ 
    if (node.left != null)
        traverse (node.left,theList); // if you return traverse(node.left,theList) here,
                                      // you end the recursion without adding the current
                                      // node and visiting the right sub-tree 
    theList.push(node.element);
    if (node.right != null)
        traverse (node.right,theList);       

    return theList;   
}
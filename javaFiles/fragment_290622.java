public int countSomething (Node node) {

    // Self;
    //   
    int result = 1;   // use your required logic here

    // Children;
    //    
    if (node.left != null)
        result += countSomething( node.left);
    if (node.right != null)
        result += countSomething( node.right);

    // done.
    return result;
}


// example usages
int treeTotal = countSomething( rootNode);
int subtreeTotal = countSomething( subtree);
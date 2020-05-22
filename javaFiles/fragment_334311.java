public printTreeNodes(){
//Declare variables for tree
        ITestDataTree cdTree;
        ITestDataTreeNodes cdTreeNodes;
        ITestDataTreeNode[] cdTreeNode;

        //Variables to hold tree data
                //tree_mytree() is the tree object you want to traverse
        cdTree = (ITestDataTree)tree_mytree().getTestData("tree");
        cdTreeNodes = cdTree.getTreeNodes();
        cdTreeNode = cdTreeNodes.getRootNodes();

        //Print out total number of nodes
        System.out.println ("Tree Total Node Count: " + cdTreeNodes.getNodeCount());
        System.out.println ("Tree Root Node Count : " + cdTreeNodes.getRootNodeCount());

        //Iterate through tree branches; this is a recursive method.
        for (int i = 0;i<cdTreeNode.length;++i)
        showTree(cdTreeNode[i], 0);
}

void showTree(ITestDataTreeNode node, int indent)
{
    //Recursive method to print out tree nodes with proper indenting.

    //Determine number of tabs to use - to properly indent tree
    int tabCount = ( indent < tabs.length() ? indent :
        tabs.length() );

    //Print out node name + number of children
    System.out.println(tabs.substring(0, tabCount) + node.getNode() + " (" + node.getChildCount() + "children)" );

    //Determine if node has children; recursively call this same
    //method to print out child nodes.
    ITestDataTreeNode[] children = node.getChildren();
    int childCount = ( children != null ? children.length : 0 );
    for ( int i = 0; i < childCount; ++i )
        showTree(children[i], indent+1);
}
//String of tabs used to indent tree view
final String tabs = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
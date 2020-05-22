class myTree extends JPanel {

private DefaultMutableTreeNode rootNode;
private DefaultTreeModel treeModel;

public myTree() {

    super(new GridLayout(1, 1)); //Set the layout for the panel that the jtree.

    //The following object is a sample from a database and was used to validate 
    //the solution below. Make sure the table is properly sorted before you create the 
    //the object from the query.
    Object[][] table = {
        {1, null, "Root"}, //i=0
        {2, 1, "Node2"}, //i=1
        {3, 2, "Node3"}, //i=2
        {4, 3, "Node4"}, //i=3
        {5, 4, "Node5"}, //i=4
        {6, 5, "Node6"}, //i=5
        {7, 6, "Node7"}, //i=6
        {8, 1, "Node8"}, //i=7
        {9, 1, "Node9"}, //i=8
        {10, 9, "Node10"},};    //i=9

    //Create as many nodes as there are rows of data.
    DefaultMutableTreeNode[] node = new DefaultMutableTreeNode[table.length];
    for (int i = 0; i < table.length; i++) {
        node[i] = new DefaultMutableTreeNode(table[i][2].toString());
    }

    rootNode = node[0];   //Set the root node

    //Cycle through the table above and assign nodes to nodes
    for (int i = 0; i < table.length; i++) {
        for (int j = 1; j < table.length; j++) {
            if (table[i][0] == table[j][1]) {
                System.out.println(table[i][2].toString() + " is parent of " + table[j][2].toString());
                node[i].add(node[j]);
            }
        }
    }
    //Creating the tree model. setting the root node.
    treeModel = new DefaultTreeModel(rootNode);
    //Setting the tree model to the JTree
    JTree tree = new JTree(treeModel);
    //adding the tree to the JPanel
    add(tree);
}
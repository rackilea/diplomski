NTree tree = new NTree();
    tree.root = new Node("A", 1, 0);
    ArrayList<Node> list_nodes = new ArrayList<Node>();
    list_nodes.add(tree.root);
    list_nodes.add(new Node("B", 2, 1));
    list_nodes.add(new Node("C", 3, 1));
    list_nodes.add(new Node("D", 4, 1));
    list_nodes.add(new Node("E", 5, 3));
    list_nodes.add(new Node("F", 6, 3));

    for (int i = 0; i < list_nodes.size(); i++) {
        Node parent = tree.find_parentNode(list_nodes, list_nodes.get(i).parentID);
        tree.addTreeNode(parent, list_nodes.get(i));
    }
    tree.preorder(tree.root);
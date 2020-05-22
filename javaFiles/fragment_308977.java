public ArrayList<String> getDataLeaves(BinaryTree<String> root) {

    ArrayList<String> list = new ArrayList<>();

    if (root == null) 
        return list;
    else if (root.isLeaf()) 
        list.add(root.data);
    else { 
        list.addAll(getDataLeaves(root.leftTree));
        list.addAll(getDataLeaves(root.rightTree));
    }

    return list;
}
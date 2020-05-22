public String inOrderNewick(Node root) throws ItemNotFoundException {
    if (root.hasChild()) {
        String output = "";
        output += "(";
        output += inOrderNewick(root.child1);
        output += ",";
        output += inOrderNewick(root.child2);
        output += ")";
        return output;
    } else {
        return root.getSeq();
    }
}
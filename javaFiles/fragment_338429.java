static TreeMap<String,ArrayList<SimpleNode>> tree = new TreeMap<String,ArrayList<SimpleNode>>();

public Stack findChildrenToDelete(SimpleNode parentNode){
    Stack nodesToDelete = new Stack();
    nodesToDelete.add(parentNode.getId());
    ArrayList<SimpleNode> children=tree.get(keyMaker(parentNode.getId(), parentNode.getType()));

    for(int i=0;i<children.size();i++){
        // add recursive children to the result
        nodesToDelete.addAll(findChildrenToDelete(children.get(i)));
    }
    return nodesToDelete;  
}
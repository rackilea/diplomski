static TreeMap<String,ArrayList<SimpleNode>> tree = new TreeMap<String,ArrayList<SimpleNode>>();

public Stack findChildrenToDelete(SimpleNode parentNode){
    return findChildrenToDelete(parentNode,new Stack());
}
public Stack findChildrenToDelete(SimpleNode parentNode, Stack nodesToDelete){
    nodesToDelete.add(parentNode.getId());
    ArrayList<SimpleNode> children=tree.get(keyMaker(parentNode.getId(), parentNode.getType()));

    for(int i=0;i<children.size();i++){
        // pass a reference to the collection recursively
        findChildrenToDelete(children.get(i),nodesToDelete);
    }
    return nodesToDelete;  
}
private boolean getDuplicateNodesOfMyCurrentNode(Node parentNode, Node currentNode,List<Node> dupNodes){
    for(Node child: parentNode.getChildren()){
        if(child == currentNode){
            return false;
        }
        if(child.getApp().equals(currentNode.getApp()){
            dupNodes.add(child);
        }
        if (getDuplicateNodesOfMyCurrentNode( builtOn, currentNode, aDupNodes) == false){
            return false;
        }
    }
    return true;
}
private Node search(String name, Node node){
    if(node != null){
        if(node.name().equals(name)){
           return node;
        } else {
            Node foundNode = search(name, node.left);
            if(foundNode == null) {
                foundNode = search(name, node.right);
            }
            return foundNode;
         }
    } else {
        return null;
    }
}
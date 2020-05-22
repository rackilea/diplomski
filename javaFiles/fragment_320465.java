List<Node> flattenTree(List<Node> nodes){
    List<Node> allNodes=new LinkedList<>(nodes) ;
    for(Node node:nodes){
        {
           if(node.getNodes()!=null)
           allNodes.addAll(flattenTree(node.getNodes()));
        } 
     return allNodes;
    }
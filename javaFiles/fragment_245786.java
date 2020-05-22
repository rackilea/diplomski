List<Node> nodesToRemove = new ArrayList<>();
for(Node node : g.getChildren()){
    if(node instanceof Text){
        nodesToRemove.add(node);
    }
}

g.getChildren().removeAll(nodesToRemove);
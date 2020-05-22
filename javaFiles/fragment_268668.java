public int distance(Node from, Node to) {

    for(Edge edge: edges){
        if(edge.getFrom().equals(from) && edge.getTo().equals(to)){
            return edge.getValue();
        }
    }
    return 1;
}
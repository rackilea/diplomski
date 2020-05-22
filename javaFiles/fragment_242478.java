int depth = current.getDepth() + 1;
ArrayList<Node> succesors = current.getSuccessors(depth);
for (Node node : succesors) {
    if (!closed.contains(node) && !open.contains(node)) {
        node.setH(this.heuristic.calculate(node, goal));
        node.setG(current.getG() + 1);
        node.setParent(current);
        open.add(node);
    } 
}
List<Node> toRemove = new LinkedList<>();
doc.traverse(new NodeVisitor() {
    @Override
    public void head(Node node, int depth) {
        // ...
        if(condition)
            toRemove.add(node);
    }
    // ...
});

for (Node node : toRemove)
    node.remove();
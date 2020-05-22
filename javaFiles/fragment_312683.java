NodeFinder finder= new NodeFinder(cu, offset, 0);
ASTNode node= finder.getCoveringNode();
while (node != null && !(node instanceof Statement)) {
    node= node.getParent();
}
return node;
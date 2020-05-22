List<Node> nodeChildren = queryNode.getChildren();
    int maxChildDepth = 0;
    for (int i = 0; i < nodeChildren.size(); i++) {
        final int currentChildDepth = checkDepthLimit(nodeChildren.get(i));
        maxChildDepth = Math.max(maxChildDepth, currentChildDepth);
    }
    depth += maxChildDepth;
    return depth;
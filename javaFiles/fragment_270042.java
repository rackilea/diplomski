public void render(Element node, AffineTransform transform) {

    AffineTransform nodeTransform = node.getCompositeTransform();
    nodeTransform.preConcatenate(transform);

    node.draw(g2d, nodeTransform);

    for (Element child : node.children())
        render(child, nodeTransform);
}
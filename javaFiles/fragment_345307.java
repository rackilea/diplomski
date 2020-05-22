ObjectNode node = nodeFactory.objectNode();
node.set("D", buildArrayNode());
...

private ArrayNode buildArrayNode() {
    // build your node here
    ArrayNode arrayNode = nodeFactory.arrayNode();
    arrayNode.add(...);
}
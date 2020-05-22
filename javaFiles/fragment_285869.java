Stream<Node> userNodes = toStream(doc.getElementsByTagName("user"));

List<String> userNames = userNodes
        .flatMap(node -> toStream(node.getChildNodes())
                .filter(n -> n.getNodeName().equals("name")))
        .map(Node::getTextContent)
        .collect(Collectors.toList());
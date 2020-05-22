NodeList anchors = doc.getElementsByTagName("img");
for (int index=0; index<anchors.getLength(); index++) {
    Node node = anchors.item(index);
    System.out.println(node.getNodeName());
    // ....
}
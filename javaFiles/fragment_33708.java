Node child1 = elemNodeList.item(j);
Node sibling = child1.getNextSibling();
while (!(sibling instanceof Element) && sibling != null) {
  sibling = sibling.getNextSibling();
}
System.out
      .println(" Get the Name of the Next Sibling " + sibling.getNodeName());
System.out
      .println(" Get the Value of the Next Sibling " + sibling.geTextContent());
// remove content variable
emp.setName(text(cNode));

// ... later ...

private String text(Node cNode) {
  return cNode.getTextContent()
              .trim();
}
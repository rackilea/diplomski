Node element0 = node.get(0);
NodeList children = element0.getChildNodes();
Node intNode0 = children.item(0);
Node intNode1 = children.item(1);
int x;
int y;
try {
  x = Integer.parseInt(intNode0.getTextContent());
  y = Integer.parseInt(intNode1.getTextContent());
} catch (Exception e) {
  System.out.println("Child node is not integer value");
}
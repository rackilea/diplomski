DefaultMutableTreeNode root = ...

Enumeration en = root.depthFirstEnumeration();
while (en.hasMoreElements()) {

  // Unfortunately the enumeration isn't genericised so we need to downcast
  // when calling nextElement():
  DefaultMutableTreeNode node = (DefaultMutableTreeNode) en.nextElement();
}
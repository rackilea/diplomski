double minX = Double.MAX_VALUE;
double maxX = Double.MIN_VALUE;

for (int i = 0; i < children.size(); i++) {
  Node node = children.get(i);
  if (node.isManaged()) {
    final double x = node.getLayoutBounds().getMinX() + node.getLayoutX();
    minX = Math.min(minX, x);
    maxX = Math.max(maxX, x + node.minWidth(-1));
  }
}
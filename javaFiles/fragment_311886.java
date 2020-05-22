Set<Node> visited = new HashSet<>();
while (a != null && b != null) {
  if (visited.contains(a)) return a;
  if (visited.contains(b)) return b;
  visited.add(a);
  visited.add(b);
  a = a.parent();
  b = b.parent();
}
while (a != null) {
  if (visited.contains(a)) return a;
  a = a.parent();
}
while (b != null) {
  if (visited.contains(b)) return b;
  b = b.parent();
}
return null;
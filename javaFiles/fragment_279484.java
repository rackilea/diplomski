public static MaxNode(Node n, char currentMax) {
  if (n == null) // base case, we're at the end.
    return currentMax;

  // recurrence
  return MaxNode(n.next, currentMax > n.item ? currentMax : n.item);
}
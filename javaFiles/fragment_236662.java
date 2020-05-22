Node *NToLastHelper(Node *behind, Node *current, int n) {
  // If n is not yet 0, keep advancing the current node
  // to get it n "ahead" of behind.
  if (n != 0) {
    return NToLastHelper(behind, current->next, n - 1);
  }
  // Since we now know current is n ahead of behind, if it is null
  // the behind must be n from the end.
  if (current->next == nullptr) {
    return behind;
  }
  // Otherwise we need to keep going.
  return NToLastHelper(behind->next, current->next, n);
}

Node *NToLast(Node *node, int n) {
  // Call the helper function from the head node.
  return NToLastHelper(node, node, n);
}
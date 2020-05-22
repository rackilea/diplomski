public E[] toArray(E[] a) {
  Node n = root;
  collect(n, a, 0);
  return a;
}

public int collect(Node n, E[] a, int i) {

  if (n.left != null) {
    // If there is a left (smaller) value, we go there first
    i = collect(n.left, a, i);
  }


  // Once we've got all left (smaller) values we can
  // collect the value of out current Node.
  a[i] = n.obj;
  i++;

  if (n.right != null) {
    // And if there is a right (larger) value we get it next
    i = collect(n.right, a, i);
  }

  return i;
}
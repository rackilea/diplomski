public E[] toArray(E[] a) {
  Node n = root;
  a = collect(n, a);
  return a;
}

public E[] collect(Node n, E[] a) {

  if (n.left != null) {
    // If there is a left (smaller) value, we go there first
    collect(n.left, a);
  }


  // Once we've got all left (smaller) values we can
  // collect the value of out current Node.
  a[i] = n.obj;
  i++;

  if (n.right != null) {
    // And if there is a right (larger) value we get it next
    collect(n.right, a);
  }

  return a;
}
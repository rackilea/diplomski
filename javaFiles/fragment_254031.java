public boolean equals(CharNode a, CharNode b) {
  if (a == null && b == null) {
    return true;
  }
  if ((a==null) ||  (b==null)) {
    return false;
  }
  if (a.getData() != b.getData()) {
    return false;
  }
  return equals(a.getNext(), b.getNext());
}
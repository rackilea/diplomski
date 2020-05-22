if (t.getLeft() != null) {
  // check nullity and THEN check match
  if (t.getLeft().getData().getCharacter() == character) {
    return t.getLeft().getData().getEncoding();
  }
  t.getLeft().getData().setEncoding(t.getLeft().getData().getEncoding() + "0");
  treeQueue.add(t.getLeft());
}

if (t.getRight() != null) {
  if (t.getRight().getData().getCharacter() == character) {
    return t.getRight().getData().getEncoding();
  }
  t.getRight().getData().setEncoding(t.getRight().getData().getEncoding() + "1");
  treeQueue.add(t.getRight());
}
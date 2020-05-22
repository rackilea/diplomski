public static int numberKnots (Tree b) {
  if (b.empty()) {
    return 0;
  } else {
    return 1 + numberKnots(b.left()) + numberKnots(b.right());
  }
}
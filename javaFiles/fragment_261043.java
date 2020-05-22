public <T extends Comparable<? super T>> void assertLessOrEqual(T left, T right) {
  if (left == null || right == null || left.compareTo(right) > 0) {
    String msg = "["+left+"] is not less than ["+right+"]";
    throw new RuntimeException("assertLessOrEqual: " + msg);
  }
}
public void print(){
  for (AddingBoth ab : list) {
    // Is your radius really a String?
    System.out.println(String.valueOf(ab.getRadius()) + " = " + ab.getValue());
  }
  // As the other answers point out you had already exhausted the iterator.
  System.out.flush();
}
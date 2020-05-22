public Integer generate() {
  synchronized( list ) {
    Collections.shuffle(list);
    return list.get(0);
  }
}
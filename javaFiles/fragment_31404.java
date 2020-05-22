boolean add(E e) {
  if(q.size()==MAX_SIZE) {
    remove();
  }
  q.add(e)
}
public String toString() {
  String ret = "[";
  Node current = head;
  while(current.getNext() != null) {
    current = current.getNext();
    ret += current.get();
    if(current.getNext() != null) ret += ", ";
  }
  return ret + "]";
}
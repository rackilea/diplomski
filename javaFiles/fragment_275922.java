class TailList extends LinkedList {
  LinkedList list;
  TailList(LinkedList list) { this.list=list;}
  Node head() { return list.head().next; }
  int length() { return list.length()-1;}
}
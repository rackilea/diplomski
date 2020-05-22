public static boolean delete(Object d, MyLinkedList<ListElement> list) {

  ListElement head = list.getHead();
  if (head.data.equals(d)) {   // <- ALWAYS use equals, never == to compare objects!!
    list.setHead(head.next);
  } else {
    ListElement element = head.next;

    // ... the rest is similiar to your algorithm

  } 
}
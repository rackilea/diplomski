public static ListElement insertList(ListElement head, int value) { 
    ListElement elt;
    if (head == null || head.value <= value) {
        elt = new ListElement();
        elt.value = value;
        elt.next = head;
        return elt;
     } else {
        head.next = insertList(head.next, value);
        return head;
     }
}
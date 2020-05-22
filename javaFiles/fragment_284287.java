public void yourMainMethod() {
    ListNode head = new ListNode("Overflow!", null);
    head = new ListNode("Stack", head);
    head = new ListNode("in", head);
    head = new ListNode("is", head);
    head = new ListNode("This", head);

    printList(head);
    System.out.println();
    printList(head);
}

//note different name, to clarify this is a separate reference
public static void printList(ListNode node) {
    while(node != null)
    {
        System.out.print(node.getValue()+" ");
        node = node.getNext();

        //node.setValue(new Object());//note that this would change the state inside the ListNode passed in
    }
}
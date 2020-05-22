private void printKthToLast(LinkedListNode head, int k, int index) {

    if(head == null) {
        return;
    }

    if(index >= k) {

        System.out.println(head.data);
    }

    printKthToLast(head.next, k, ++index);
}
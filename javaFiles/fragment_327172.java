public void deleteNextNode(ListNode node) {
    if(node == null || node.next == null) return; //nothing to delete
    if(node.next.next == null){
        node.next = null;
        return;
    } else{
        node.next = node.next.next;
    }
}
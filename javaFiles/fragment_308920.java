public void remove(int value) {
    IntegerNode curr = head;
    IntegerNode prev = null;

        for (curr = head; curr != null; curr = curr.next) {
            if(curr.item == value) {
                if (prev == null) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                    count--;
            }
            prev = curr;
        }
}
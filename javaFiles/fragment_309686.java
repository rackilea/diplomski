protected void remove(E value, Tester<E> extraCondition) {
    if(front != null) {
        ListNode<E> current = front;
        if(front.data.equals(value)) {
            front = front.next;
        } else {
            boolean hasRemovedElement = false;
            while(current.next != null && !hasRemovedElement 
                    && extraCondition.test(current.next.data) {
                if(current.next.data.equals(value)) {
                    current.next = current.next.next;
                    hasRemovedElement = true;
                }
                current = current.next;
            }
        }
    }
}
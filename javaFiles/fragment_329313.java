public int pop() {
        if (head == null)
           return 0;

        SintNode t = head;
        head = t.next;
        t = null;
        return 0;

}
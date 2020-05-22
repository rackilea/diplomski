public static void main(String[] args) {
    ListNode k = Something.method();

    while(k.next != null){
        System.out.println(k.val);
        k = k.next;
    }

}

private static class ListNode {
    int val;
    ListNode next = null;
    ListNode(int x) { val = x; }
}

public static class Something {
    public static ListNode method() {

        ListNode node = new ListNode(0);
        ListNode out = node;

        for (int i = 1; i < 10; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }

        return out;
    }
}
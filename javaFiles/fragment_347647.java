class ListNode
{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class ReverseRightHalfLinkedList 
{
    public static void main(String[] args) 
    {       
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;


        ListNode res = reverse(node1);

        ListNode node = node1;
        while (node != null)
        {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode reverse(ListNode start)
    {   
        int counter = 0;
        ListNode node = start;
        ListNode pre = start;

        ListNode result = start;

        while (node!= null)// for count how many elements in linked list
        {
            counter += 1;
            node = node.next;           
        }

        for (int i=0; i< (counter / 2) ; i++)//no matter counter is even or odd, when it divided by 2, the result is even
        {   
            pre = start;
            start = start.next; 
        }


        ListNode temp = null;
        ListNode preNext = null;// this variable is used to track the next val behind pre
        // for example, 2->1->3->4->5->6->7->8
        // at this moment, pre:4, start:5
        // I treated 5->6->7->8 as an independent linkedlist
        // I reversed the linkedlist 
        // Finally, set the pre node's next value to the reversed linkedlist's head
        // The first half and second half have been connected together


        while (start != null)
        {
            temp = start.next;
            start.next = preNext;
            preNext = start;
            start = temp;
        }
        pre.next = preNext;

        return start;

    }
}
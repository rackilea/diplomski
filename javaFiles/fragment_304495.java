public static void invert(ListNode head)
{
    ListNode previous = null;
    ListNode current = head.link;
    ListNode forward;

    while (current != null)
    {
        forward = current.link;
        current.link = previous;
        previous = current;
        current = forward;
    }

    System.out.println("Here is the inverted list.");
    head.link = previous;
    printLinked(head);
}
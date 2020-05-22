Node InsertNth(Node head, int data, int position) {
    Node temp = new Node();
    temp.data = data;
    Node start = head;
    Node curr = start;
    if (position == 0)
    {
        temp.next = start;
        return temp;
    } 
    else
    {
        for(int i = 0; i < position; i++)
        {
            curr=start;
            start=start.next;
        }
        curr.next=temp;
        temp.next=start;
        return head;
    } 
}
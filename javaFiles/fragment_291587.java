public void reverse()
{
    Node current = head.getNext();
    Node prevNode = null;
    Node nextNode;

    while(current!=null)
    {
        nextNode = current.getNext();
        current.setNext(prevNode);
        prevNode = current;
        current = nextNode;
        System.out.println(prevNode.getData());
    }

    head.setNext(prevNode);

}
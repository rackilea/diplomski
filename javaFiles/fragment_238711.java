public DSStack()
{
    theStack = new DSList();
}

public DSStack( DSStack other )
{
    this();
    // Rest of the code goes on 
    // Create a reference for the stack to be copied
    Node oldListNode = other.theStack.head;

    while (oldListNode != null) 
    {
        this.push(oldListNode.getToken());
        oldListNode = oldListNode.next;
    }

}
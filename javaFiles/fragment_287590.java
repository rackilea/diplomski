while(tthis!=null)
{
    if(tthis.obj.getKey().compareTo(newNode.obj.getKey())>=0)
    {
        if(tthis==prev)//if first node
        {
            newNode.next=head;
            head=newNode;
        }
        else //if you're inserting not before first node
        {
            newNode.next=tthis;
            prev.next=newNode;
        }
        break; //breaking and not further looping
    }
    else //if key of this< key of newNode
    {
        prev=tthis;
        tthis=tthis.next;
    }
}
if (tthis == null) { //This means that we have reached the end of the list without inserting the element
  prev.next = newNode; //Create the link from the last node.
}
while(ptr1!=null)
{
    Node nnode=new Node();
    nnode.data=ptr1.data;

    if(isEmpty())
    {
        start1=nnode;
    }
    else
    {
        nnode.link=start1;
        start1=nnode;
    }
}
void add(Customer customer)
{
    Customer temp = customer;

    if (ptr == null)
    {
        ptr = temp;
    }
    else
    {
        Customer x = ptr;
        Customer n = ptr;

        while (x.next != null)
        {
            x = x.next;
            n.next.prev = n;
            n = n.next;
        }

        x.next = temp;
        temp.prev = x;
        ptr.prev = temp;// ******** edited line ******
    }

}
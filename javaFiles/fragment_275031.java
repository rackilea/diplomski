public void insertFirst(int id, double dd)
{         
    if (isEmpty())
    {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }
    else
    {
        if (first.iData < id)
        {
            Link newLink = new Link(id, dd);
            newLink.next = first;
            first = newLink;
        }
        else
        {
            int iTempData = first.iData;
            double dTempData = first.dData;

            first.iData = id; // replace first
            first.dData = dd; // (do not add new)

            Link newLink2 = new Link(iTempData, dTempData);
            newLink2.next = first;
            first = newLink2;
        }
    }
}
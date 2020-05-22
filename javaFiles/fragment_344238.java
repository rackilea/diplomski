public void sortList()
{
    if (isEmpty())
    {
        System.out.println("An empty list is already sorted");
    }
    else if (getHead().getNext() == null)
    {
        System.out.println("A one-element list is already sorted");
    }
    else
    {
        Node current = getHead();
        boolean swapDone = true;
        while (swapDone)
        {
            swapDone = false;
            while (current != null)
            {
                if (current.getNext() != null && current.getData().getSurname().compareTo(current.getNext().getData().getSurname()) >0)
                {
                    CustomerFile tempDat = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(tempDat);
                    swapDone = true;
                }
                current = current.getNext();
            }
            current = getHead();
        }
    }
}
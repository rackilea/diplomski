int getNoOfWaypoints()
{
    int count = 1;
    TourElement current = getNext();
    while(current.next != null)
    {
        count++;
        System.out.println(count);
        current = current.next;
    }
    return count;
}
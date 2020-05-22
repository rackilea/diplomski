class CompareDate implements Comparator<NewContact>
{
    public int compare(NewContact c1, NewContact c2)
    {
        if (c1.getDate() > c2.getDate()
        {
            return 1;
        }
        else if (c1.getDate() == c2.getDate()
        {
            return 0;
        }
        return -1;
    }
}
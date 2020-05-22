public class SortItemHelper implements Comparable<SortItemHelper>
{
    Data data;
    int originalIndex;

    public int compareTo(SortItemHelper other)
    {
        if (other == null)
            return 1;
        return data.compareTo(other.data);
    }
    ...
}
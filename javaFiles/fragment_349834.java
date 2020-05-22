public abstract class Item<T> implements Comparable<Item<T>>
{
    protected T item;

    public int compareTo(Item<T> o)
    {
        return 0; // this doesn't matter for the time being
    }
}
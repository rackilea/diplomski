public LinkedList<T> collection;

public Collection()
{
    collection = new LinkedList<>();
}

public void addToList(T new)
{
    int i = 0;
    while (collection.get(i).compareTo(new) < 0)
    {
        i++;
    }
    collection.add(i, new);
}
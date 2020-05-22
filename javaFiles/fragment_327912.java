public Iterator iterator()
{
    return new SetIterator(this);
}

public boolean add(Object o)
{
    for (Object item : this)
        if (o.equals(next)) return false;
    }
    // add code to put o in the array
    return true;
}
public void enqueue(Date d)
{
    add(tailIndex, d);
}

public void enqueue(CInteger i)
{
    add(tailIndex, new Integer(i.getValue()); //access the int value and cast to Integer object
}
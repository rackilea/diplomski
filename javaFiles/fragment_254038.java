constructor()
{
    FIFO current = new FIFO();
    FIFO alternate = new FIFO();
}

add(Object x)
{
    return current.add(x);
}

get()
{
    Object x = current.get();
    alternate.add(x);
    return x;
}

size()
{
    return current.size();
}

mark()
{
    alternate = new FIFO();
}

rewind()
{
    while (current.size > 0)
    {
        alternate.add(current.get());
    }
    current = alternate;
    alternate = new FIFO();
}
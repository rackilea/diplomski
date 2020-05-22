public int size()
{
    int count = 0;
    for (T element : stack)
    {
        if(element != null)
            count++;
    }

    return count;
}
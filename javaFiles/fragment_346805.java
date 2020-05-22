public boolean isEmpty()
{
    for (T element : stack)
    {
        if(element != null)
        {
            return false;
        }
    }

    return true;
}
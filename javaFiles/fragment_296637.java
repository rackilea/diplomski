public RWIterator<T> Search(T e)
{
    RWIterator<T> myIterator = Iterator();
    bool found = false;
    foreach (T element in myIterator)
    {
        if (found)
            yield return element;
        else if (element.Equals(e))
        {
            found = true;
            yield return element;
        }
    }
}
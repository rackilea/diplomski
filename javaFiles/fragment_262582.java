public static <T> ArrayList<T> rotate(ArrayList<T> aL, int shift)
{
    if (aL.size() == 0)
        return aL;

    T element = null;
    for(int i = 0; i < shift; i++)
    {
        // remove last element, add it to front of the ArrayList
        element = aL.remove( aL.size() - 1 );
        aL.add(0, element);
    }

    return aL;
}
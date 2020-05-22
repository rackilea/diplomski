public static <T extends Comparable<T>> List<T> removeFromList(List<T> list, T current) 
{
    Iterator<T> itr = list.iterator();
    while(itr.hasNext())
    {
        T elm = itr.next();
        if(elm.compareTo(current) <= 0)
            itr.remove();
    }

    return list;
}
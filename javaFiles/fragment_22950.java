public static <T> List<T> removeFromList(List<T> list, T current,
        Comparator<T> comp) {
    Iterator<T> itr = list.iterator();
    while(itr.hasNext())
    {
        T elm = itr.next();
        if(comp.compare(elm, current) <= 0)
            itr.remove();
    }
    return list;
}
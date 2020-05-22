public static <T> T find(Collection<?> arrayList, Class<T> clazz)
{
    for(Object o : arrayList)
    {
        if (o != null && o.getClass() == clazz)
        {
            return clazz.cast(o);
        }
    }

    return null;    
}